package serialize.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import entityDemo.Message;
import entityDemo.Person;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonSerializeDemo {

    static JsonSelf jsonSelf = new JacksonSelf(new ObjectMapper());
    //static JsonSelf jsonSelf = new GsonSelf(new Gson());

    public static void main(String[] args) throws IOException {

        TypeTab<Message<Person>> messageType = new TypeTab<Message<Person>>(){};


        System.out.println(" ===== message 泛型 =========");
        Message<Person> message = new Message<>(new Person("trojan"));
        String json = genericSerialize(message);
        Message<Person> msg = generacDeserilize(json, messageType);
        System.out.println(" 反序列化为message对象结果：\ncode:"
                + message.getCode() + "\nname:" + msg.getData().getName());


        HashMap<String, Object> msgMap = (HashMap<String, Object>) generacDeserilize2Map(json);
        System.out.println(" 反序列化为hashMap对象结果：\ncode:"
                + msgMap.get("code") + "\nname:" + ((Map) (msgMap.get("data"))).get("Name"));


        System.out.println("====== Home=====");
        Home home = new Home();
        home.setAddr("china");
        Person father = new Person("baba");

        List<Person> childs = new ArrayList<>();
        Person son = new Person("son");
        Person girl = new Person("girl");

        childs.add(son);
        childs.add(girl);

        home.setFather(father);
        home.setChild(childs);

        // 序列化
        String homeJson= genericSerialize(home);
        // 反序列化
        generacDeserilizeDeepObject(homeJson);

    }

    // 泛型序列化
    public static String genericSerialize(Object object){
        String json = jsonSelf.serialize(object);
        System.out.println(json);
        return json;
    }

    // 泛型反序列化 TypeReference 特定对象
    public static <T> T generacDeserilize(String json, TypeTab<T> tab){

        return jsonSelf.deSerialize(json, tab);
    }

    // 泛型反序列化 map
    public static Map<String ,Object> generacDeserilize2Map(String json){
        return jsonSelf.deSerialize(json, HashMap.class);
    }

    // 嵌套反序列化
    public static void generacDeserilizeDeepObject(String json) {
        Home home = jsonSelf.deSerialize(json, Home.class);
        String addr = home.getAddr();
        Person father = home.getFather();
        List<Person> childs = home.getChild();

        String childNames = childs.stream().map(e -> e.getName()).collect(Collectors.toList()).toString();

        System.out.println(MessageFormat.format("home info:\naddr:{0}\n" +
                "father name:{1}\nchild names:{2}", addr, father.getName(), childNames));
    }

    static class Home {
        private String addr;
        private Person father;
        private List<Person> child;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public Person getFather() {
            return father;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public List<Person> getChild() {
            return child;
        }

        public void setChild(List<Person> child) {
            this.child = child;
        }
    }

}



