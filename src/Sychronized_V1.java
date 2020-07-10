import sun.jvm.hotspot.types.CIntegerField;

//Synchronized的基本使用
//需要注意的是，如果需要锁定某个对象，则synchronized (lock)中的lock必须要是同一个对象！

public class Sychronized_V1 {

    static final Integer lock = new Integer(1);
    static final Integer lock1 = new Integer(1);
    static Integer i = 0;
    static Integer ii = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                ()->{
                    synchronized (lock) {
                        int j = 0;
                        while (j < 5000) {
                            j = j + 1;
                            i = i + 1;
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                ()->{
                    synchronized (lock) {
                        int j = 0;
                        while (j < 5000) {
                            j = j + 1;
                            i = i + 1;
                        }
                    }
                }
        );

        Thread t3 = new Thread(
                ()->{
                    synchronized (lock1) {
                        int j = 0;
                        while (j < 5000) {
                            j = j + 1;
                            ii = ii + 1;
                        }
                    }
                }
        );

        Thread t4 = new Thread(
                ()->{
                    synchronized (lock1) {
                        int j = 0;
                        while (j < 5000) {
                            j = j + 1;
                            ii = ii + 1;
                        }
                    }
                }
        );
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("i is : " + i);
        System.out.println("ii is : " + ii);
    }
}
