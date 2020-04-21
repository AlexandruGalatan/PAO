package CashRegister;
import javax.xml.crypto.Data;
import java.util.*;

public class CashRegister {

    private List<Product> Products = new ArrayList<Product>();
    private List<Employee> Employees = new ArrayList<Employee>();
    private List<PaymentMethod> PaymentMethods = new ArrayList<PaymentMethod>();
    private List<Transaction> Transactions = new ArrayList<Transaction>();

    private Employee ActiveEmployee;
    private ShoppingCart ActiveCart;
    private int LastId;

    DataStore dataStore = DataStore.getInstance();
    Audit audit = Audit.getInstance();

    public CashRegister() {
        LastId = 0;
        LoadData();
        System.out.println("Cash Register Active");
        PrintSeparator();
        audit.log("register_activated");
    }

    public void LoadData(){
        System.out.println("Loading existent data...");
        int maxId = 0;

        //Load Products
        System.out.println("Loading Products...");
        List<String> prods = dataStore.readUsingBufferedWriter("products.csv");
        for (int i = 0; i < prods.size(); i++){
            String line = prods.get(i);
            String[] fields = line.split(",");
            int thisID = Integer.parseInt(fields[1]);
            float thisPrice = Float.parseFloat(fields[3]);
            int prodCat = Integer.parseInt(fields[0]);

            Product loadedProd = null;
            if (prodCat == 0){
                loadedProd = AddProduct(thisID, fields[2], thisPrice);
            }
            if (prodCat == 1){
                loadedProd = AddProductElectronic(thisID, fields[2], thisPrice, Integer.parseInt(fields[4]));
            }
            if (prodCat == 2){
                loadedProd = AddProductClothing(thisID, fields[2], thisPrice, fields[4]);
            }

            loadedProd.Print();
            System.out.println("");

            if (thisID > maxId){
                maxId = thisID;
            }
        }
        System.out.println("Done");

        //Load Employees
        System.out.println("Loading Employees...");
        List<String> emps = dataStore.readUsingBufferedWriter("employees.csv");
        for (int i = 0; i < emps.size(); i++){
            String line = emps.get(i);
            String[] fields = line.split(",");
            int thisID = Integer.parseInt(fields[0]);
            Employee emp = AddEmployee(thisID, fields[1]);

            emp.Print();

            if (thisID > maxId){
                maxId = thisID;
            }
        }
        System.out.println("Done");

        //Load Payment Methods
        System.out.println("Loading Payment Methods...");
        List<String> paymen = dataStore.readUsingBufferedWriter("paymentMethods.csv");
        for (int i = 0; i < paymen.size(); i++){
            String line = paymen.get(i);
            String[] fields = line.split(",");
            int thisID = Integer.parseInt(fields[0]);


            PaymentMethod pm = AddPaymentMethod(thisID, fields[1]);

            pm.Print();

            if (thisID > maxId){
                maxId = thisID;
            }
        }
        System.out.println("Done");

        //Load Transactions
        System.out.println("Loading Transactions...");
        List<String> transac = dataStore.readUsingBufferedWriter("transactions.csv");
        for (int i = 0; i < transac.size(); i++){
            String line = transac.get(i);
            String[] fields = line.split(",");

            int thisID = Integer.parseInt(fields[0]);
            int empID = Integer.parseInt(fields[1]);
            int payID = Integer.parseInt(fields[2]);

            PaymentMethod paymentMethod = GetPaymentMethod(payID);
            Employee emp = GetEmployee(empID);
            ShoppingCart car = new ShoppingCart();

            for (i = 3; i < fields.length; i++){
                int prodId = Integer.parseInt(fields[i]);
                Product prd = GetProduct(prodId);
                car.AddToCart(prd);
            }
            Transaction newTransaction = new Transaction(thisID, emp, car, paymentMethod);
            Transactions.add(newTransaction);

            newTransaction.PrintTransaction();

            if (thisID > maxId){
                maxId = thisID;
            }
        }
        System.out.println("Done");

        LastId = maxId + 1;
        System.out.println("Data completely loaded.");
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

        audit.log("GetTopEmployee");

        return TopEmployees.first();
    }

    public ShoppingCart GetActiveCart(){
        CheckCart();
        audit.log("GetActiveCart");
        return ActiveCart;
    }

    public Product GetProduct(int productId){
        int i;
        for (i = 0; i < Products.size(); i++){
            if (Products.get(i).GetID() == productId){
                return Products.get(i);
            }
        }
        audit.log("GetProduct");
        return null;
    }
    public Employee GetEmployee(int employeeId){
        int i;
        for (i = 0; i < Employees.size(); i++){
            if (Employees.get(i).GetID() == employeeId){
                return Employees.get(i);
            }
        }
        audit.log("GetEmployee");

        return null;
    }
    public PaymentMethod GetPaymentMethod(int paymentMethodId){
        int i;
        for (i = 0; i < PaymentMethods.size(); i++){
            if (PaymentMethods.get(i).GetID() == paymentMethodId){
                return PaymentMethods.get(i);
            }
        }
        audit.log("GetPaymentMethod");
        return null;
    }

    private Employee AddEmployee(int id, String name){
        Employee newEmployee = new Employee(id, name);
        Employees.add(newEmployee);
        return newEmployee;
    }
    public Employee CreateEmployee(String name) {
        int thisId = GetId();

        String csv = Integer.toString(thisId).concat(",").concat(name);
        dataStore.writeUsingBufferedWriter(csv, "employees.csv");

        audit.log("CreateEmployee");

        return AddEmployee(thisId, name);
    }

    private Product AddProduct(int id, String name, float price){
        Product newProduct = new Product(id, name, price);
        Products.add(newProduct);

        return newProduct;
    }
    public Product CreateProduct(String name, float price) {
        int productId = GetId();

        String csv = "0,".concat(Integer.toString(productId)).concat(",").concat(name).concat(",").concat(Float.toString(price));
        dataStore.writeUsingBufferedWriter(csv, "products.csv");

        audit.log("CreateProduct");

        return AddProduct(productId, name, price);
    }

    private Product AddProductElectronic(int id, String name, float price, int monthsWarranty){
        ElectronicProduct newProduct = new ElectronicProduct(id, name, price, monthsWarranty);
        Products.add(newProduct);
        return  newProduct;
    }

    public Product CreateElectronicProduct(String name, float price, int monthsWarranty) {
        int thisId = GetId();

        String csv = "1,".concat(Integer.toString(thisId)).concat(",").concat(name).concat(",").concat(Float.toString(price)).concat(",").concat(Integer.toString(monthsWarranty));
        dataStore.writeUsingBufferedWriter(csv, "products.csv");

        audit.log("CreateElectronicProduct");

        return AddProductElectronic(thisId, name, price, monthsWarranty);
    }

    private Product AddProductClothing(int id, String name, float price, String size){
        ClothingProduct newProduct = new ClothingProduct(id, name, price, size);
        Products.add(newProduct);
        return  newProduct;
    }

    public Product CreateClothingProduct(String name, float price, String size) {
        int thisId = GetId();

        String csv = "2,".concat(Integer.toString(thisId)).concat(",").concat(name).concat(",").concat(Float.toString(price)).concat(",").concat(size);
        dataStore.writeUsingBufferedWriter(csv, "products.csv");

        audit.log("CreateClothingProduct");

        return AddProductClothing(thisId, name, price, size);
    }

    private PaymentMethod AddPaymentMethod(int id, String name){
        PaymentMethod newPaymentMethod = new PaymentMethod(id, name);
        PaymentMethods.add(newPaymentMethod);
        return  newPaymentMethod;
    }
    public PaymentMethod CreatePaymentMethod(String name){
        int thisId = GetId();

        String csv = Integer.toString(thisId).concat(",").concat(name);
        dataStore.writeUsingBufferedWriter(csv, "paymentMethods.csv");

        audit.log("CreatePaymentMethod");

        return AddPaymentMethod(thisId, name);
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
        audit.log("SetActiveEmployee");
    }

    public ShoppingCart AddToCart(int productId){
        CheckCart();

        Product addProduct = GetProduct(productId);
        ActiveCart.AddToCart(addProduct);

        System.out.print("Product added: ");
        addProduct.Print();
        System.out.println("");
        PrintSeparator();

        audit.log("AddToCart");

        return ActiveCart;
    }

    public ShoppingCart AddToCart(int productId, int amount){
        int i;

        for (i = 0; i < amount; i++){
            AddToCart(productId);
        }

        audit.log("AddToCart");

        return ActiveCart;
    }

    public void RemoveFromCart(int pos){
        Product Removed = GetActiveCart().RemoveFromCart(pos);
        System.out.print("Product removed from cart: ");
        Removed.Print();
        System.out.println("");
        PrintSeparator();

        audit.log("RemoveFromCart");
    }

    public void EmptyCart(){
        ActiveCart = null;
        audit.log("EmptyCart");
    }

    public Transaction TransactionCompleted(int paymentMethodId){
        PaymentMethod paymentMethod = GetPaymentMethod(paymentMethodId);
        Transaction newTransaction = new Transaction(GetId(), ActiveEmployee, ActiveCart, paymentMethod);
        Transactions.add(newTransaction);

        String csv = Integer.toString(newTransaction.GetID()).concat(",").concat(Integer.toString(ActiveEmployee.GetID())).concat(",").concat(Integer.toString(paymentMethodId));
        List<Product> transacitems = newTransaction.GetCart().GetProducts();
        for (int i = 0; i < transacitems.size(); i++) {
            Product Current = transacitems.get(i);
            csv = csv.concat(",").concat(Integer.toString(Current.GetID()));
        }
        dataStore.writeUsingBufferedWriter(csv, "transactions.csv");

        EmptyCart();

        ActiveEmployee.AddSale(1);

        System.out.println("Transaction completed!");
        paymentMethod.Print();
        System.out.println("");
        PrintSeparator();

        audit.log("TransactionCompleted");

        return newTransaction;
    }

    public void PrintCart(){
        System.out.println("Contents of Shopping Cart:");
        GetActiveCart().Print();
        PrintSeparator();

        audit.log("PrintCart");
    }

    public void PrintAllTransactions(){
        int i;

        System.out.println("Transactions:");
        for (i = 0; i < Transactions.size(); i++){
            Transactions.get(i).PrintTransaction();
            PrintSeparator();
        }

        audit.log("PrintAllTransactions");
    }

    public void PrintSeparator(){
        System.out.println("--------------------");
        System.out.println("");
        audit.log("PrintSeparator");
    }
}
