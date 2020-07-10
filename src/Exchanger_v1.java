import java.util.concurrent.Exchanger;

public class Exchanger_v1 {

    static Exchanger<String> ex = new Exchanger<>();
    public static void main(String[] args) {

        Thread t1 = new Thread(
                ()->{
                    int i = 0;
                    while(i <= 100) {
                        i = i + 1;
                        String str = "Thread 1";
                        try {
                            System.out.println(ex.exchange(str));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        Thread t2 = new Thread(
                ()->{
                    int i = 0;
                    while(i <= 100) {
                        i = i + 1;
                        String str = "Thread 2";
                        try {
                            System.out.println(ex.exchange(str));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        t1.start();
        t2.start();
    }

}
