package CashRegister;

public class ClothingProduct extends Product{
    private String Size;

    public ClothingProduct(int id, String name, float price, String size) {
        super(id, name, price);
        this.Size = size;
    }

    public void Print(){
        super.Print();
        System.out.print("".concat(" Size: ").concat(Size));
    }
}
