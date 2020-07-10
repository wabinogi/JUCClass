import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//基本使用:循环触发
public class CyclicBarrier_v2 {

    static CyclicBarrier barrier ;
    public static void main(String[] args) throws InterruptedException {

        barrier = new CyclicBarrier(3,
                () -> {
            System.out.println("Every one is OK !");
        });

        Thread t1 = new Thread(
                () ->
                {
                    try {
                        for(int i=0; i <10; i++) {
                            System.out.println("T1 is OK !");
                            barrier.await();
                        }
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
                    try {
                        for(int i=0; i <10; i++) {
                            System.out.println("T2 is OK !");
                            barrier.await();
                        }
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
                    try {
                        for(int i=0; i <10; i++) {
                            System.out.println("T3 is OK !");
                            barrier.await();
                        }
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
