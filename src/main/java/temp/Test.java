package temp;

import com.google.common.primitives.Bytes;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;
import com.sun.xml.internal.ws.encoding.MtomCodec;
import entityDemo.Country;
import entityDemo.Person;
import org.springframework.mail.MailException;

import javax.sound.midi.Soundbank;
import javax.swing.text.StyledEditorKit;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        /*System.out.println(Target.class.getSimpleName());
        System.out.println(Target.class.getName());*/
/*
        TargetB targetB = new TargetB();
        System.out.println(targetB instanceof Target);
        System.out.println(targetB instanceof C);*/

        /*Method method = null;
        try {
            method = Target.class.getMethod("test", new Class[]{Integer.class, String.class, List.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Type[] types = method.getParameterTypes();
        TypeVariable<Method>[] types1 = method.getTypeParameters();

        System.out.println(types.length == types1.length);*/

       /* Test test = new Test();
        Target target = new Target();
        target.name = "name1";
        System.out.println(target.name);
        System.out.println("= = = = = = = = = = = = = = = = = = = =");

        test.warpData(target);
        System.out.println(target.name);*/

        //List<String> abc = new ArrayList<>();
        /*abc.add("hello");
        abc.add("world");
        String ss = abc.toString();
        System.out.println(ss);*/


        /*String str = "hello,world";
        String bb[] = str.split(",");
        abc = Arrays.asList(bb);
        System.out.println(abc.toString());*/

       /* String ss = "[abc],[dd]";
        ss  = ss.replaceAll("(\\[|\\])", "");
        System.out.println(ss);*/

        /*List<Person> people = new ArrayList<>();
        Person person1 = new Person();
        person1.setName("p1");
        Person person2 = new Person();
        person2.setName("p2");

        people.add(person1);
        people.add(person2);
        System.out.println(people.get(0).getName()+"==" +people.get(1).getName());
        people = people.stream().map(e -> {
            e.setName("hello");
            return e;
        }).collect(Collectors.toList());
        System.out.println(people.get(0).getName()+"==" +people.get(1).getName());*/
        //System.out.println(Integer.valueOf("3000000003"));

       /* List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list);
        List<String> stringList = list.stream().filter(e -> e > 4).map(e -> e.toString()).collect(Collectors.toList());
        System.out.println(stringList);*/

        /*String url = "http://zclass.zhan.com/index.html?token=3900623543CA075ABF1EDE6DE4064A7D&class_id=3301&class_type=0&lesson_id=1&live=0";
        String newUrl = url.replaceAll("&class_id=([0-9]*)&", "&class_id="+1100+"&");
        System.out.println(url);
        System.out.println(newUrl);*/
        Integer a = 1;
        System.out.println(Integer.valueOf(1).equals(a));
        System.out.println(a.equals(1));
    }

    public static void warpData(Target target) {
        target = new Target();
        target.name = "target change";

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

    public String name;

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

class TargetB extends Target implements C{
    public Target target;

    public void sayName() {
        System.out.println("target B name");
    }

}

interface C {}



