package temp;

import org.springframework.mail.MailException;

import javax.sound.midi.Soundbank;
import java.io.Serializable;
import java.lang.reflect.Method;

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

        Class clazz = Inner.class;
        try {
            Method method = clazz.getMethod("fun");
            System.out.println(clazz.equals(method.getDeclaringClass()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static class Inner implements Serializable{
        public void fun(){}
    }
}


