import java.util.concurrent.locks.LockSupport;

//LockSupport基本使用
//使用许可证机制，且许可证不能叠加！
//unpark方法可以取消后面的park方法

public class LockSupport_v2 {


    public static void main(String[] args) {

        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("Main");


    }
}
