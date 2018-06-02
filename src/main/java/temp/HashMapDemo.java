package temp;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<MyValue,Object> hashMap = new HashMap<MyValue, Object>();
        hashMap.put(new MyValue("one"),"first");
        hashMap.put(new MyValue("two"),"secend");
        for(int i=0;i<18;i++){
            hashMap.put(new MyValue("dump"),"dump");
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
