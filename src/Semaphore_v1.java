import java.util.concurrent.Semaphore;

//基本使用

public class Semaphore_v1 {

    //设置了最多5个信号！！
    //代表最多有5个线程可并发执行！
    static Semaphore shared = new Semaphore(4);
    public static void main(String[] args) {

        for (int i = 0; i < 21;i++) {
             new Thread(
                    () -> {
                        try {
                            shared.acquire(2);
                            System.out.println("T1 !!!");
                            Thread.sleep(500);
                            shared.release(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
        }
    }
}
