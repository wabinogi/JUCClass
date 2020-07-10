import java.util.concurrent.CountDownLatch;

public class CountDownLatch_v1 {

    //计数器设为3
    static CountDownLatch latch = new CountDownLatch(3);
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                () ->
                {
                    latch.countDown();
                    System.out.println("T1 is OK !");
                }
        );

        Thread t2 = new Thread(
                () ->
                {
                    System.out.println("T2 is OK !");
                    latch.countDown();
                }
        );

        Thread t3 = new Thread(
                () ->
                {
                    System.out.println("T3 is OK !");
                    latch.countDown();
                }
        );

        t1.start();
        t2.start();
        t3.start();
        latch.await(); //main线程阻塞中，等待t1 t2 t3都countDown后，计数器从3变为0后继续运行
        System.out.println("Every T is OK !");
    }
}
