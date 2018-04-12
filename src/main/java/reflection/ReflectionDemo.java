package reflection;

import entityDemo.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        try {
            Person person = new Person();
            Method method = person.getClass().getMethod("say",String.class);
            method.invoke(person,"hello");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

