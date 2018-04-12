import entityDemo.Country;

public class Demo {
    public static  void main(String[] args){
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        System.out.println(cat.hashCode());
        System.out.println(cat1.hashCode());
        System.out.println("cat equals cat1:"+cat.equals(cat1));
        System.out.println("cat = cat1:"+(cat == cat1));
    }
}

class Cat{

}
