import java.util.concurrent.CountDownLatch;

public class CountDownLatch_v2 {

    static CountDownLatch latch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                () ->
                {
                    try {
                        latch.await();
                        System.out.println("T1 Beginning !");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread t2 = new Thread(
                () ->
                {
                    try {
                        latch.await();
                        System.out.println("T2 Beginning !");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread t3 = new Thread(
                () ->
                {
                    try {
                        latch.await();
                        System.out.println("T3 Beginning !");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Start !");
        latch.countDown();
    }
}
