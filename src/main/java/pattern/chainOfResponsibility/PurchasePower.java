package pattern.chainOfResponsibility;

import entityDemo.PurchaseRequest;

abstract class PurchasePower {
    protected static final double BASE = 500;
    public PurchasePower successor;

    abstract protected double getAllowable();
    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor){
        this.successor = successor;
    }

    public void processRequest(PurchaseRequest request){
        if(request.getAmout() < this.getAllowable()){
            System.out.println(request.getPurpose()+"will approve $"+request.getAmout() + ". By "+this.getRole());
        }else if(successor != null){
            successor.processRequest(request);
        }
    }
}

class ManagerPPower extends PurchasePower{
    protected double getAllowable() {
        return BASE * 10;
    }

    protected String getRole() {
        return "Manager";
    }
}

class DirectorPPower extends PurchasePower{
    protected double getAllowable() {
        return BASE * 20;
    }

    protected String getRole() {
        return "Director";
    }
}

class VicePresidentPPower extends PurchasePower{
    protected double getAllowable() {
        return BASE * 60;
    }

    protected String getRole() {
        return "VicePresident";
    }
}

class PresidentPPower extends PurchasePower{
    protected double getAllowable() {
        return BASE * 100;
    }

    protected String getRole() {
        return "President";
    }
}
