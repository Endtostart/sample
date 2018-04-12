package pattern.chainOfResponsibility;

import entityDemo.PurchaseRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class PurchasePowerDemo {
    public static void main(String[] args){
        PurchasePower manager = new ManagerPPower();
        PurchasePower director = new DirectorPPower();
        PurchasePower vicePresident = new VicePresidentPPower();
        PurchasePower president = new PresidentPPower();

        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(president);

        System.out.println("please input acount,let't me see,who can approve your request.");
        System.out.println(">");
        try {
            double account = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine().toString());
            manager.processRequest(new PurchaseRequest(account,"buyBook"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
