package CashRegister;

public class Transaction {
    private int ID;
    private Employee ActiveEmployee;
    private ShoppingCart Cart;
    private PaymentMethod Payment;

    public Transaction(int ID, Employee activeEmployee, ShoppingCart cart, PaymentMethod payment) {
        this.ID = ID;
        this.ActiveEmployee = activeEmployee;
        this.Cart = cart;
        this.Payment = payment;
    }

    public void PrintTransaction(){
        System.out.println("Transaction".concat("").concat(" [ID ").concat(Integer.toString(ID)).concat("]"));
        ActiveEmployee.Print();
        Payment.Print();
        Cart.Print();
    }

    public int GetID(){
        return this.ID;
    }
    public ShoppingCart GetCart(){return this.Cart;};
}
