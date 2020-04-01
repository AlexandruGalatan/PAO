package CashRegister;

public class PaymentMethod {
    private int ID;
    private String Name;

    public PaymentMethod(int id, String name) {
        this.ID = id;
        this.Name = name;
    }

    public int GetID(){
        return this.ID;
    }

    public void Print(){
        System.out.println("Payment Method: ".concat(Name).concat(" [ID ").concat(Integer.toString(ID)).concat("]"));
    }
}
