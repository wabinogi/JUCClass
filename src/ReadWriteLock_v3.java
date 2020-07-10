import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁基本使用
//写锁和写锁是同步的，互斥的！
public class ReadWriteLock_v3 {

    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    static Integer i = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread writeThd = new Thread(
                ()->{
                    for(int x =0; x < 1000; x ++) {
                        rwlock.writeLock().lock();
                        i = i + 1;
                        rwlock.writeLock().unlock();
                    }
                }
        );

        Thread readT1 = new Thread(
                ()->{

                    for(int x =0; x < 1000; x ++) {
                        rwlock.writeLock().lock();
                        i = i + 1;
                        rwlock.writeLock().unlock();
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
