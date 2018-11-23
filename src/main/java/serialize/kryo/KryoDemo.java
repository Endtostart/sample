package serialize.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import serialize.jdk.Dog;
import serialize.jdk.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class KryoDemo {
    public static void main(String[] args) {
        User<Dog> user = new User<>();
        user.setName("trojan");
        user.setAge(20);
        user.setSign("hello");
        user.setFriends(new Object[]{"Jane"});

        Dog dog = new Dog();
        dog.setAge(6);
        dog.setName("旺财");
        user.setPet(dog);

        String filePath = "D:/demofile.class";

        Kryo kryo = new Kryo();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        kryo.writeObject(output,user);
        output.flush();
        byte[] bytes = bos.toByteArray();

        System.out.println("out:==>\n" + bytes.toString());

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Input input = new Input(bis);
        User user1 = kryo.readObject(input, User.class);

        Dog dog1 = (Dog) user1.getPet();

        System.out.println("userName : " + user1.getName());
        System.out.println("dogName : " + dog1.getName());

    }
}
