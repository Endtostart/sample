package serialize.jdk;

import java.io.Serializable;

public class User<T> implements Serializable {
    private static final long serialVersionUID = 1168814620391610215L;

    private String name;
    private Integer age;
    private transient String sign;
    private Object[] friends;
    private T pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Object[] getFriends() {
        return friends;
    }

    public void setFriends(Object[] friends) {
        this.friends = friends;
    }

    public T getPet() {
        return pet;
    }

    public void setPet(T pet) {
        this.pet = pet;
    }
}
