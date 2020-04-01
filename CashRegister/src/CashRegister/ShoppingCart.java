package CashRegister;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> Products = new ArrayList<Product>();
    private float Total;

    public ShoppingCart(){
        Total = 0;
    }

    public void AddToCart(Product add){
        Products.add(add);
        Total = Total + add.Price;
    }

    public Product RemoveFromCart(int pos){
        Product Item = Products.get(pos);
        Total = Total - Item.Price;
        Products.remove(pos);
        return Item;
    }

    public void Print(){
        int i;
        for (i = 0; i < Products.size(); i++){
            Product Current = Products.get(i);
            System.out.print("".concat(Integer.toString(i)).concat(": "));
            Current.Print();
            System.out.println(" - ".concat(Float.toString(Current.Price)));
        }
        System.out.println("Total: ".concat(Float.toString(GetTotal())));
    }

    public float GetTotal(){
        return Total;
    }

}
