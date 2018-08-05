package jdk;

public class InterfaceTest extends LoginServiceImpl implements LoginService{

    /*@Override
    public int login(){
        System.out.println("this method return type is int");
    }*/

    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.login();
    }
}

interface LoginService {
    public void login();
}

class LoginServiceImpl {
    public void login(){
        System.out.println("login");
    }
}

interface TargetService{
    public int login();
}
