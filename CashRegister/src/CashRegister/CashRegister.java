package CashRegister;
import java.util.*;

public class CashRegister {

    private List<Product> Products = new ArrayList<Product>();
    private List<Employee> Employees = new ArrayList<Employee>();
    private List<PaymentMethod> PaymentMethods = new ArrayList<PaymentMethod>();
    private List<Transaction> Transactions = new ArrayList<Transaction>();

    private Employee ActiveEmployee;
    private ShoppingCart ActiveCart;
    private int LastId;

    public CashRegister() {
        LastId = 0;
        System.out.println("Cash Register Active");
        PrintSeparator();
    }

    private int GetId(){
        LastId += 1;
        return LastId;
    }

    public Employee GetTopEmployee(){
        int i;
        SortedSet<Employee> TopEmployees = new TreeSet<Employee>();

        for (i = 0; i < Employees.size(); i++){
            TopEmployees.add(Employees.get(i));
        }

        return TopEmployees.first();
    }

    public ShoppingCart GetActiveCart(){
        CheckCart();
        return ActiveCart;
    }

    public Product GetProduct(int productId){
        int i;
        for (i = 0; i < Products.size(); i++){
            if (Products.get(i).GetID() == productId){
                return Products.get(i);
            }
        }
        return null;
    }
    public Employee GetEmployee(int employeeId){
        int i;
        for (i = 0; i < Employees.size(); i++){
            if (Employees.get(i).GetID() == employeeId){
                return Employees.get(i);
            }
        }
        return null;
    }
    public PaymentMethod GetPaymentMethod(int paymentMethodId){
        int i;
        for (i = 0; i < PaymentMethods.size(); i++){
            if (PaymentMethods.get(i).GetID() == paymentMethodId){
                return PaymentMethods.get(i);
            }
        }
        return null;
    }

    public Employee CreateEmployee(String name) {
        Employee newEmployee = new Employee(GetId(), name);
        Employees.add(newEmployee);
        return newEmployee;
    }

    public Product CreateProduct(String name, float price) {
        Product newProduct = new Product(GetId(), name, price);
        Products.add(newProduct);
        return newProduct;
    }

    public Product CreateElectronicProduct(String name, float price, int monthsWarranty) {
        ElectronicProduct newProduct = new ElectronicProduct(GetId(), name, price, monthsWarranty);
        Products.add(newProduct);
        return newProduct;
    }

    public Product CreateClothingProduct(String name, float price, String size) {
        ClothingProduct newProduct = new ClothingProduct(GetId(), name, price, size);
        Products.add(newProduct);
        return newProduct;
    }

    public PaymentMethod CreatePaymentMethod(String name){
        PaymentMethod newPaymentMethod = new PaymentMethod(GetId(), name);
        PaymentMethods.add(newPaymentMethod);
        return newPaymentMethod;
    }

    private void CheckCart(){
        if (ActiveCart == null){
            ActiveCart = new ShoppingCart();
        }
    }

    public void SetActiveEmployee(int employeeId){
        ActiveEmployee = GetEmployee(employeeId);
        System.out.print("Active employee is now ");
        ActiveEmployee.Print();
        PrintSeparator();
    }

    public ShoppingCart AddToCart(int productId){
        CheckCart();

        Product addProduct = GetProduct(productId);
        ActiveCart.AddToCart(addProduct);

        System.out.print("Product added: ");
        addProduct.Print();
        System.out.println("");
        PrintSeparator();

        return ActiveCart;
    }

    public ShoppingCart AddToCart(int productId, int amount){
        int i;

        for (i = 0; i < amount; i++){
            AddToCart(productId);
        }

        return ActiveCart;
    }

    public void RemoveFromCart(int pos){
        Product Removed = GetActiveCart().RemoveFromCart(pos);
        System.out.print("Product removed from cart: ");
        Removed.Print();
        System.out.println("");
        PrintSeparator();
    }

    public void EmptyCart(){
        ActiveCart = null;
    }

    public Transaction TransactionCompleted(int paymentMethodId){
        PaymentMethod paymentMethod = GetPaymentMethod(paymentMethodId);
        Transaction newTransaction = new Transaction(GetId(), ActiveEmployee, ActiveCart, paymentMethod);
        Transactions.add(newTransaction);
        EmptyCart();

        ActiveEmployee.AddSale(1);

        System.out.println("Transaction completed!");
        paymentMethod.Print();
        System.out.println("");
        PrintSeparator();
        return newTransaction;
    }

    public void PrintCart(){
        System.out.println("Contents of Shopping Cart:");
        GetActiveCart().Print();
        PrintSeparator();
    }

    public void PrintAllTransactions(){
        int i;

        System.out.println("Transactions:");
        for (i = 0; i < Transactions.size(); i++){
            Transactions.get(i).PrintTransaction();
            PrintSeparator();
        }
    }

    public void PrintSeparator(){
        System.out.println("--------------------");
        System.out.println("");
    }
}
