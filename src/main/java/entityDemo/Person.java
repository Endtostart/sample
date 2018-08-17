package entityDemo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("Name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void say(String name){
        System.out.println("say:"+name);
    }

    public void run(){
        System.out.println("i'am run");
    }
}
