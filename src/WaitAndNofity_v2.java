public class WaitAndNofity_v2 {
//关于synchronized(lock),是线程安全的，因为锁定的是一个对象
//notify和wait交替使用

    static Integer lock = 0;
    static WaitAndNofity_v2 instance = new WaitAndNofity_v2();
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Thd()).start();
        Thread.sleep(100);
        instance.Method();
    }

    public void Method() throws InterruptedException {
            int count = 0;
            while (count < 4000) {
                count = count + 1;
                synchronized (lock) {
                        System.out.println("Main Thread !");
                        lock.notify();
                        lock.wait();

                    }
            }
    }


    static public class Thd implements Runnable{

        @Override
        public void run() {

            int count = 0;
            while (count < 4000) {
                    count = count + 1;
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("XXXXXXXXTHD  Thread !");
                        lock.notify();
                    }
                }
        }
    }
}
