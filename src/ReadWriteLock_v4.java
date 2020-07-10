import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁基本使用
//读写完全互斥
//writeThd写上锁，readT1不能读，反之亦然
public class ReadWriteLock_v4 {

    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    static Integer i = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread writeThd = new Thread(
                ()->{
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    rwlock.writeLock().lock();
                    System.out.println("writelock");
                }
        );

        Thread readT1 = new Thread(
                ()->{

                    rwlock.readLock().lock();
                    System.out.println("readlock");
                }
        );


        writeThd.start();
        readT1.start();

    }
}
