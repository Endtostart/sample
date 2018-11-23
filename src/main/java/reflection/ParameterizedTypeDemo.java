package reflection;

import entityDemo.Person;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Des 获取泛型类型
 * @Author N.wang
 * @Date 13:14 2018/11/19
 * @Param
 * @return
 **/
public class ParameterizedTypeDemo {
    public static void main(String[] args) {
        Class a = new A<Person>() {
        }.getClass();
        ParameterizedType pt = (ParameterizedType) a.getGenericSuperclass();
        Type type = pt.getActualTypeArguments()[0];
        System.out.println("class -->> " + type);

    }

}

class A<T> {
    Class<T> clazz;
}
