import java.util.concurrent.Phaser;


public class Phaser_v1
{
    static MyPhaser myPhaser = new MyPhaser();
    public static void main(String[] args) {
        myPhaser.bulkRegister(3);
        Thread T1 = new Thread(
                ()->{
                    int i = 0;
                    while (i <=3) {
                        i= i+1;
                        System.out.println(Thread.currentThread().getName() + " T1 was reached !");
                        //任意线程T到达屏障点后，进入阻塞等待其他线程，直到达到parties：3的阈值，所有T接触阻塞
                        myPhaser.arriveAndAwaitAdvance();
                        myPhaser.arriveAndDeregister();
                    }
                }
        );
        T1.start();

        Thread T2 = new Thread(
                ()->{
                    int i = 0;
                    while (i <=3) {
                        i= i+1;
                        System.out.println(Thread.currentThread().getName() + " T2 was reached !");
                        //任意线程T到达屏障点后，进入阻塞等待其他线程，直到达到parties：3的阈值，所有T接触阻塞
                        myPhaser.arriveAndAwaitAdvance();
                          //myPhaser.arriveAndDeregister();
                    }
                }
        );
        T2.start();

        Thread T3 = new Thread(
                ()->{
                    int i = 0;
                    while (i <=3) {
                        i= i+1;
                        System.out.println(Thread.currentThread().getName() + " T3 was reached !");
                        //任意线程T到达屏障点后，进入阻塞等待其他线程，直到达到parties：3的阈值，所有T接触阻塞
                        myPhaser.arriveAndAwaitAdvance();
                        // myPhaser.arriveAndDeregister();
                    }
                }
        );
        T3.start();

        }


    public static class MyPhaser extends Phaser {

        @Override
        public boolean onAdvance(int phase,int registeredParties)
        {
            //定义phase中的阶段
            if(!isTerminated())
            {
                if(phase ==0)
                {
                    System.out.println("Phase A was reached !");
                }
                else if (phase == 1)
                {
                    System.out.println("Phase B was reached !");
                }
                else if (phase == 2)
                {
                    System.out.println("Phase C was reached !");
                }
            }
            return super.onAdvance(phase,registeredParties);
        }
    }
}