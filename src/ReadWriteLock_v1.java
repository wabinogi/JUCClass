import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁基本使用
public class ReadWriteLock_v1 {

    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    static Integer i = 0;
    public static void main(String[] args) {

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
                    for(int x =0; x < 10; x ++) {
                        rwlock.readLock().lock();
                       System.out.println("readT1 : " + i);
                        rwlock.readLock().unlock();
                    }
                }
        );

        Thread readT2 = new Thread(
                ()->{
                    for(int x =0; x < 10; x ++) {
                        rwlock.readLock().lock();
                        System.out.println("readT2 : " + i);
                        rwlock.readLock().unlock();
                    }
                }
        );
        writeThd.start();
        readT1.start();
        readT2.start();
    }
}
