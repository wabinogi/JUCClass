public class WaitAndNofity_v1 {
//关于synchronized的错误用法
//no并不是线程安全的，因为synchronized(this)锁定的是不同的对象
    static Integer no = 0;
    public static void main(String[] args) throws InterruptedException {
        WaitAndNofity_v1 instance = new WaitAndNofity_v1();
        Thread tt = new Thread(new Thd());
        tt.start();
        instance.Method();
        tt.join();
        System.out.println("no is : " + no);
    }

    public void Method()
    {
        synchronized (this) {
            int count = 0;
            while (count < 10000) {
                count = count + 1;
                no = no + 1;
            }
        }
    }


    static public class Thd implements Runnable{

        @Override
        public void run() {
            synchronized (this) {
                int count = 0;
                while (count < 10000) {
                    count = count + 1;
                    no = no + 1;
                }
            }
        }
    }
}
