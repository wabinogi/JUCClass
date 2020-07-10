import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁基本使用
//多个读锁是共享的，异步的，不是线程同步的！
public class ReadWriteLock_v2 {

    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    static Integer i = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread writeThd = new Thread(
                ()->{
                    for(int x =0; x < 1000; x ++) {
                        rwlock.readLock().lock();
                        i = i + 1;
                        rwlock.readLock().unlock();
                    }
                }
        );

        Thread readT1 = new Thread(
                ()->{

                    for(int x =0; x < 1000; x ++) {
                        rwlock.readLock().lock();
                        i = i + 1;
                        rwlock.readLock().unlock();
                    }

                }
        );


        writeThd.start();
        readT1.start();
        writeThd.join();
        readT1.join();
        System.out.println("RESULT : " + i);
    }
}
