import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//基本使用
//等待数设置为1 ，实现交替执行
public class CyclicBarrier_v3 {

    static CyclicBarrier barrier ;
    public static void main(String[] args) throws InterruptedException {

        barrier = new CyclicBarrier(1,
                () -> {
            System.out.println("A is OK !");
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
        t1.start();
    }
}
