package entityDemo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Person {

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    @JsonProperty("Name")
    @SerializedName("Name")
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
