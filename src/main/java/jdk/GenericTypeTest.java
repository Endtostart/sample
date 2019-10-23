package jdk;

import entityDemo.Message;
import entityDemo.Person;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeTest {
    public static Class<?> getGenericType(Class<?> clazz) {
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) type).getActualTypeArguments();
            return (Class<?>) p[0];
        }
        return null;
    }

    public static void main(String[] args) {
        //MyMessage<Person> message = new MyMessage<Person>();
        Message<Person> message = new Message<Person>(){};
        getGenericType(message.getClass());
    }

    static class MyMessage<Person> extends Message<Person> {

    }

}
