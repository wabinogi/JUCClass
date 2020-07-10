import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

//基本使用
//模拟ABA
//AtomicStampedReference使用

public class AtomicStampedReference_v1 {

    static AtomicStampedReference<Object> sr;
    public static void main(String[] args) throws InterruptedException {


        Info young = new Info("wabinogi",18);
        Info old = new Info("wabinogi",50);
        sr = new AtomicStampedReference<>(young,0); //young对象初始版本号为0

        //改成其他引用,版本0
        sr.set(old,0);
        //改成下一版本，版本1
        sr.set(young,1);

        //得到版本号
        System.out.println(sr.getStamp());
        System.out.println(((Info)sr.getReference()).age);
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
