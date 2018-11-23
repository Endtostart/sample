package temp;

import com.google.common.primitives.Bytes;
import entityDemo.Country;
import org.springframework.mail.MailException;

import javax.sound.midi.Soundbank;
import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        /*String a = "a";
        String b = "b";
        String ab = a+b;
        String cc = "cd"+"dc";
        System.out.println(ab == "ab");
        System.out.println(ab.intern() == "ab");
        System.out.println(ab == "ab");
        System.out.println(cc == "cddc");*/
        /*float a = 100000000.0f;
        System.out.println("...95 --> " + (a ==  99999995));  //false
        System.out.println("...96 --> " + (a ==  99999996));
        System.out.println("...98 --> " + (a ==  99999998));
        System.out.println("...99 --> " + (a ==  99999999));
        System.out.println("...00 --> " + (a ==  100000000));
        System.out.println("...01 --> " + (a ==  100000001));
        System.out.println("...02 --> " + (a ==  100000002));
        System.out.println("...03 --> " + (a ==  100000003));
        System.out.println("...04 --> " + (a ==  100000004));
        System.out.println("...05 --> " + (a ==  100000005));   //false
        System.out.println("=================================");
        System.out.println(100.000001f == 100);*/

        /*Class clazz = Inner.class;
        try {
            Method method = clazz.getMethod("fun");
            System.out.println(clazz.equals(method.getDeclaringClass()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }*/

        /*TT tt = new TT();
        tt.show();*/

        /*System.out.println(Integer.valueOf(127) == Integer.valueOf(127));
        System.out.println(new Integer(1000).equals(1000));*/


        /*Target.show();
        Target target = new Target(3);
        target.show();
        Target.show();*/


        /*int c = 65538;
        System.out.println("EXCLUSIVE_MASK : " + EXCLUSIVE_MASK);
        System.out.println("exclusiveCount : " + exclusiveCount(c));*/


     /*   Country country = new Country("china", 1300);
        System.out.println("county : " + country);
        System.out.println("do" + null);
        System.out.println(new String() + null);*/


       /* Target target = new Target();

        TargetB targetB = new TargetB();

        target.targetB = targetB;
        targetB.target = target;

        target.sayName();
        targetB.sayName();

        targetB.target.sayName();
        target.targetB.sayName();*/

        System.out.println(Target.class.getSimpleName());
        System.out.println(Target.class.getName());


    }
    static final int SHARED_SHIFT   = 16;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    public static int exclusiveCount(int c) {
        return c & EXCLUSIVE_MASK;
    }

    /*public static class Inner implements Serializable{
        public void fun(){}
    }*/
}
/*
class TT {
    public static int a = 5;

    public static void show() {
        System.out.println(a);
    }
}*/

class Target {

    TargetB targetB;

    public byte[] bytes;

    public static int a = 1;

    public static void change(int x) {
        a = x;
    }

    public Target(int a) {
        this.a = a;
    }
    public Target(){}

    public static void show() {
        System.out.println(a);
    }

    public Boolean isEmpty() {
        return Objects.isNull(bytes) || bytes.length == 0;
    }

    public void sayName() {
        System.out.println("target name");
    }
}

class TargetB {
    public Target target;

    public void sayName() {
        System.out.println("target B name");
    }

}



