package CashRegister;

public class Employee implements Comparable<Employee>{
    private String Name;
    private int ID;
    private int Sales;

    public Employee(int id, String name) {
        this.ID = id;
        this.Name = name;
        this.Sales = 0;
    }
    public int GetID(){
        return this.ID;
    }
    public String GetName(){
        return this.Name;
    }
    public void AddSale(int amount){
        this.Sales += amount;
    }
    public int GetSales(){
        return this.Sales;
    }
    public void Print(){
        System.out.println("Employee: ".concat(Name).concat(" [ID ").concat(Integer.toString(ID)).concat("]"));
    }

    @Override
    public int compareTo(Employee other) {
        if (other.GetSales() > this.Sales){
            return 1;
        }
        if (other.GetSales() < this.Sales){
            return -1;
        }
        return 0;
    }
}
