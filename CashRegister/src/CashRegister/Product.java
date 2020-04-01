package CashRegister;

public class Product {
    protected String Name;
    protected float Price;
    protected int ID;

    public Product(int id, String name, float price) {
        this.ID = id;
        this.Name = name;
        this.Price = price;
    }
    public int GetID(){
        return this.ID;
    }

    public void ChangePrice(float newPrice){
        this.Price = newPrice;
    }

    public void Print(){
        System.out.print(Name.concat(" [ID ").concat(Integer.toString(ID)).concat("]"));
    }
}
