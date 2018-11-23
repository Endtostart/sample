package serialize.jdk;

import java.io.Serializable;

public class Dog implements Serializable {
    private static final long serialVersionUID = 1168814620391610218L;
    private String name;
    private Integer age;

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
}
