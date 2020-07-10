import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

//基本使用，main和t1线程使用AtomicReference对引用变量进行修改
//t1先cas访问修改，main cas时失败
//线程安全的引用类型
public class AtomicReference_v1 {
    Object o1 = new Object();
    static AtomicReference<Object> ar = new AtomicReference();

    public static void main(String[] args) throws InterruptedException {

        Info young = new Info("wabinogi",18);
        Info mid = new Info("wabinogi",30);
        Info old = new Info("wabinogi",50);
        ar.set(young);

        Thread thd = new Thread(
                ()->
                {
                    ar.compareAndSet(young,mid);
                }
        );
        thd.start();

        Thread.sleep(100); //等T1 CAS改完
        System.out.println(ar.compareAndSet(young,old)); //只做一次CAS，模拟失败情况。
        System.out.println(((Info)ar.get()).age); //查看ar中young对象age值
    }

        static public class Info
        {
            public String name;
            public int age;
            public Info(String na,int ag)
            {
                this.name = na;
                this.age = ag;
            }
        }
}
