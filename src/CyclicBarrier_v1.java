import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

//基本使用
public class CyclicBarrier_v1 {

    static CyclicBarrier barrier = new CyclicBarrier(3,() -> { System.out.println("Every one is OK !");});
    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(
                () ->
                {
                    try {
                        System.out.println("T1 is OK !");
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread t2 = new Thread(
                () ->
                {
                    System.out.println("T2 is OK !");
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread t3 = new Thread(
                () ->
                {
                    System.out.println("T3 is OK !");
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
        );

        t1.start();
        t2.start();
        t3.start();

    }
}
