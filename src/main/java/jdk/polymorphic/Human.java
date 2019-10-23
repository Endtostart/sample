package jdk.polymorphic;

public class Human {
    public static void say() {
        System.out.println("Human say");
    }

    public void eat() {
        System.out.println("Human eat");
    }

    public static void main(String[] args) {
        Human man = new Man();
        man.say();
        man.eat();
    }
}

class Man extends Human {
    public static void say() {
        System.out.println("Man say");
    }

    public void eat() {
        System.out.println("Man say");
    }
}


