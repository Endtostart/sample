package temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashDemo {
    public static void main(String[] args) {
        /*String s = "hello world";
        String ss = "hello world";

        System.out.println(s.equals(ss));
        System.out.println(s == ss);

        String sss = s.intern();

        System.out.println(s.equals(ss));
        System.out.println(s == ss);

        System.out.println("===================");
        String a = "hello";
        String b = " world";

        String ab = "hello"+" world";
        String bb = a + b;
        System.out.println(s == ab);
        System.out.println(bb == ab);

        String str = new String("hello world");
        System.out.println(str == s);
        System.out.println(str.intern() == s);
        System.out.println(str.intern());
        System.out.println(bb.intern());

        System.out.println("a Hash:"+s.hashCode());
        System.out.println("ab Hash:"+ ab.hashCode());
        System.out.println("bb Hash:"+bb.hashCode());

        System.out.println("==========================");
        String tt = s;
        a = "HELLO";
        s = "Hello Wrold";
        System.out.println(tt);
        System.out.println(bb);*/

       /* String s = "hello world";
        String str = new String("hello world");
        System.out.println(s.hashCode());
        System.out.println(str.hashCode());
        System.out.println(s.equals(str));

        System.out.println("==================");
        Integer i = new Integer(3);
        Integer i2 = new Integer(3);
        System.out.println(i == i2);
        Integer in = new Integer(10000);
        int in2 = 10000;
        System.out.println(in == in2);

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("Integer.valueOf(100)==Integer.valueOf(100)"+(Integer.valueOf(100)==Integer.valueOf(100)));
        System.out.println("Integer.valueOf(200)==Integer.valueOf(200)"+(Integer.valueOf(200)==Integer.valueOf(200)));

        int a = 5;
        Integer b = new Integer(5);
        Integer c = new Integer(5);
        System.out.println(a == b); //true
        System.out.println(b == c); //false*/

        Map<MyValue,Object> hashMap = new HashMap<MyValue, Object>();
        hashMap.put(new MyValue("one"),"first");
        hashMap.put(new MyValue("two"),"secend");
        for(int i=0;i<10;i++){
            hashMap.put(new MyValue("dump"),"dump");
        }

        Set set = hashMap.entrySet();
        Object obj = hashMap.get(new MyValue("dump"));
        if(obj instanceof MyValue ){
            obj = (MyValue)obj;
            System.out.println(obj);
        }

    }

    private static class MyValue{
        String value;
        public MyValue(String value){
            this.value = value;
        }

        public int hashCode(){
            return value.hashCode();
        }

        public boolean equals(MyValue v){
            return false;
        }

        public String toString(){
            return value;
        }
    }


}
