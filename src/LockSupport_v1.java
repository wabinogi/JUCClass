import java.util.concurrent.locks.LockSupport;

//LockSupport基本使用
//不需要使用Syn进行锁定
//可以unpark别的线程

public class LockSupport_v1 {

    static Thread t1;
    static Thread t2;
    public static void main(String[] args) {

         t1 = new Thread(
                ()->{
                    for (int i =0; i <100 ; i++)
                    {
                        System.out.println("T1----");
                        LockSupport.unpark(t2);
                        LockSupport.park(t1);
                    }
                }
        );

         t2 = new Thread(
                ()->{
                    for (int i =0; i <100 ; i++)
                    {
                        LockSupport.park();
                        System.out.println("T2");
                        LockSupport.unpark(t1);
                    }
                }
        );

        t1.start();
        t2.start();
    }
}
