import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁基本使用
//锁降级
//当主线程锁降级后，如果不释放写锁，其他线程仍然不可读！
public class ReadWriteLock_lockDG {

    static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    static Integer i = 0;
    public static void main(String[] args) throws InterruptedException {

        rwlock.writeLock().lock();
        rwlock.readLock().lock();
        System.out.println("Main method !");

        //不解锁，新线程无法读写访问
        //rwlock.writeLock().unlock();

        Thread readT1 = new Thread(
                ()->{
                    rwlock.readLock().lock();
                    while (true) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("readlock");
                    }
                }
        );


        readT1.start();

    }
}
