import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

//基本使用，t1 t2线程并发对AtomicBoolean设值值
//看成是AtomicInteger，只有0，1两个值

public class AtomicBoolean_v1 {
    static AtomicBoolean ab = new AtomicBoolean(); //初始值为0

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                ()->{
                    ab.set(true);
                }
        );
        t1.start();

        Thread t2 = new Thread(
                ()->{
                    ab.set(false);
                }
        );
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ab.get());
    }
}
