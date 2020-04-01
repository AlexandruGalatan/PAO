import CashRegister.CashRegister;

public class main {
    public static void main(String[] args) {
        CashRegister Register = new CashRegister();

        int CashID = Register.CreatePaymentMethod("Cash").GetID();

        int AppleID = Register.CreateProduct("Apple", 2).GetID();
        int WaterBottleID = Register.CreateProduct("Water Bottle", 3).GetID();
        int BreadID = Register.CreateProduct("Bread", 1).GetID();

        int ToasterID = Register.CreateElectronicProduct("Toaster", 100, 12).GetID();

        int BlackTShirtID = Register.CreateClothingProduct("Black T-Shirt", 25, "M").GetID();

        int BobEmployeeID = Register.CreateEmployee("Bob").GetID();

        Register.SetActiveEmployee(BobEmployeeID);

        Register.AddToCart(BreadID);
        Register.AddToCart(AppleID);
        Register.AddToCart(WaterBottleID);
        Register.AddToCart(ToasterID);
        Register.AddToCart(BlackTShirtID);

        Register.PrintCart();

        Register.TransactionCompleted(CashID);

        Register.AddToCart(WaterBottleID);

        Register.TransactionCompleted(CashID);

        Register.PrintAllTransactions();

        Register.GetTopEmployee().Print();
    }
}
