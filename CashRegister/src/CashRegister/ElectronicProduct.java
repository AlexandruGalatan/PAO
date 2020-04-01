package CashRegister;

public class ElectronicProduct extends Product{
    private int MonthsWarranty;

    public ElectronicProduct(int id, String name, float price, int monthsWarranty) {
        super(id, name, price);
        this.MonthsWarranty = monthsWarranty;
    }

    public void Print(){
        super.Print();
        System.out.print("".concat(" Warranty: ").concat(Integer.toString(MonthsWarranty).concat(" months") ));
    }
}
