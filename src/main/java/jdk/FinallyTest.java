package jdk;

public class FinallyTest {
    public static int test(int i){
        int a = 20;
        int num = 0;
        try {
            num = a / i;
            return num;
        }catch (Exception e){
            num = 10;
            return num;
        }finally {
            num++;
            //return num;
        }
    }

    public static void main(String[] args) {
        System.out.println("i = 2 test:");
        System.out.println(FinallyTest.test(2));
        System.out.println("i = 0 test:");
        System.out.println(FinallyTest.test(0));

    }

}
