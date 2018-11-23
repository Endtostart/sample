package serialize.jdk;

import java.io.*;

public class SerializableDemo {
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
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(user);
            out.flush();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));

            User shadow = (User) is.readObject();
            System.out.println("name:" + shadow.getName() + ",age:" + shadow.getAge() + ",sign:" + shadow.getSign());

            Dog dogShadow = (Dog) shadow.getPet();
            System.out.println("dogInfo ==> name:" + dogShadow.getName() + ",age:" + dogShadow.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
