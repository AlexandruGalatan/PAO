package CashRegister.JDBC;

public class test {
    public static void main(String[] args) {
        System.out.println("Hello!");
        dbmanager db = new dbmanager();
        db.createEmployee(1, "yeah");
        db.updateEmployee(1, "Nope");
        System.out.println(db.readEmployee(1));
        db.removeEmployee(1);
        db.close();
    }
}
