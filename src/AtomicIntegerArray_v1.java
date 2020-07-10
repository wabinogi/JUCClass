import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

//基本使用：t1 t2在数组中对index 0的元素并发设值
//线程安全的数组

public class AtomicIntegerArray_v1 {
    static AtomicIntegerArray atomicArray = new AtomicIntegerArray(10);

    public static void main(String[] args) throws InterruptedException {


        Thread t2 = new Thread(
                ()->{
                    atomicArray.set(0,10);
                }
        );
        t2.start();

        Thread t1 = new Thread(
                ()->{
                    atomicArray.set(0,1);
                }
        );
        t1.start();


        t1.join();
        t2.join();
        System.out.println(atomicArray.get(0));
    }
}
