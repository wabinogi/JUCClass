import java.util.concurrent.atomic.LongAdder;

//LongAdder使用方法
//定义共享变量longAdder la
//定义并开启T1 T2 T3三个线程，三个线程使用la.increment 并发 加值
//主线程等三个线程结束后，取得la返回值。

public class LongAddr_v1 {
    static LongAdder la = new LongAdder(); //初始值为0

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                ()->{
                    int x = 1;
                    while (x <= 100)
                    {
                        x = x + 1;
                        la.increment();
                    }
                }
        );
        t1.start();

        Thread t2 = new Thread(
                ()->{
                    int x = 1;
                    while (x <= 100)
                    {
                        x = x + 1;
                        la.increment();
                    }
                }
        );
        t2.start();

        Thread t3 = new Thread(
                ()->{
                    int x = 1;
                    while (x <= 100)
                    {
                        x = x + 1;
                        la.increment();
                    }
                }
        );
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println(la.longValue());
        System.out.println(la.sum());
        System.out.println(advanceProbe(1));
    }

    //一个好玩的伪随机数算法
    static final int advanceProbe(int probe) {
        probe ^= probe << 13;   // xorshift
        probe ^= probe >>> 17;
        probe ^= probe << 5;
        return probe;
    }
}
