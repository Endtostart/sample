package entityDemo;

/**
 * @author N.Wang
 * @desc use by pattern.chainOfResponsibility.PurchaseDemo
 *
 */
public class PurchaseRequest {
    private double amout;
    private String purpose;

    public PurchaseRequest(double amout,String purpose){
        this.amout = amout;
        this.purpose = purpose;
    }

    public double getAmout() {
        return amout;
    }

    public void setAmout(double amout) {
        this.amout = amout;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
