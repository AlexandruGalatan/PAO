package CashRegister.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbmanager {

    Connection con;

    private void loadtables() {
        executeQuery("DROP TABLE employees");
        executeQuery("DROP TABLE paymentMethods");
        executeQuery("DROP TABLE products");
        executeQuery("DROP TABLE audit");

        executeQuery("CREATE TABLE IF NOT EXISTS employees (id INT PRIMARY KEY, name VARCHAR(30))");

        executeQuery("CREATE TABLE IF NOT EXISTS paymentMethods (id INT PRIMARY KEY, name VARCHAR(30))");

        executeQuery("CREATE TABLE IF NOT EXISTS products (type INT, id INT PRIMARY KEY, name VARCHAR(30), price FLOAT, extra VARCHAR(30))");

        executeQuery("CREATE TABLE IF NOT EXISTS audit (id INT PRIMARY KEY AUTO_INCREMENT, method VARCHAR(30), ts VARCHAR(60))");

        executeQuery("COMMIT");
    }

    public ResultSet query(String q) {
        ResultSet rs = null;
        try {

            Statement stmt = con.createStatement();

            rs = stmt.executeQuery(q);

        } catch (Exception e) {
            System.out.println(e);

        }
        return rs;
    }

    public boolean executeQuery(String q){
        boolean rs = false;
        try {

            Statement stmt = con.createStatement();

            rs = stmt.execute(q);

        } catch (Exception e) {
            System.out.println(e);

        }
        return rs;
    }

    public boolean executeCommitQuery(String q){
        if (executeQuery(q)){
            return executeQuery("COMMIT");
        }
        return false;
    }

    public dbmanager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "hello");

            ResultSet rs = query("show databases");
            while (rs.next())
                System.out.println(rs.getString(1));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Connected to database.");
        loadtables();
        System.out.println("Loaded tables");
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getStr(ResultSet rs){
        try {
            String result = "";
            while (rs.next())
                result = result.concat(rs.getString(1)).concat("; ");
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Error";
    }

    public void createEmployee(int id, String name){
        String q = "INSERT INTO employees VALUES(";
        q = q.concat(Integer.toString(id)).concat(",'").concat(name).concat("')");
        System.out.println(q);
        executeCommitQuery(q);
    }

    public String readEmployee(int id){
        String q = "SELECT name FROM employees WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        return getStr(query(q));
    }

    public void updateEmployee(int id, String name){
        String q = "UPDATE employees SET name = '".concat(name).concat("' WHERE id = ").concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void removeEmployee(int id){
        String q = "DELETE FROM employees WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void createPaymentMethod(int id, String name){
        String q = "INSERT INTO paymentMethods VALUES(";
        q = q.concat(Integer.toString(id)).concat(",'").concat(name).concat("')");
        System.out.println(q);
        executeCommitQuery(q);
    }

    public String readPaymentMethod(int id){
        String q = "SELECT name FROM paymentMethods WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        return getStr(query(q));
    }

    public void updatePaymentMethod(int id, String name){
        String q = "UPDATE paymentMethods SET name = '".concat(name).concat("' WHERE id = ").concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void removePaymentMethod(int id){
        String q = "DELETE FROM paymentMethods WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void createAudit(String action, String ts){
        String q = "INSERT INTO audit VALUES(NULL, '";
        q = q.concat(action).concat("','").concat(ts).concat("')");
        System.out.println(q);
        executeCommitQuery(q);
    }

    public String readAudit(int id){
        String q = "SELECT name FROM audit WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        return getStr(query(q));
    }

    public void updateAudit(int id, String method){
        String q = "UPDATE audit SET method = '".concat(method).concat("' WHERE id = ").concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void removeAudit(int id){
        String q = "DELETE FROM audit WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void createProduct(int type, int id, String name, float price, String extra){
        String q = "INSERT INTO products VALUES(";
        q = q.concat(Integer.toString(type)).concat(",").concat(Integer.toString(id)).concat(",'").concat(name).concat("',").concat(String.valueOf(price)).concat(",'").concat(extra).concat("')");
        System.out.println(q);
        executeCommitQuery(q);
    }

    public String readProduct(int id){
        String q = "SELECT * FROM products WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        return getStr(query(q));
    }

    public void updateProduct(int id, String name){
        String q = "UPDATE products SET name = '".concat(name).concat("' WHERE id = ").concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }

    public void removeProduct(int id){
        String q = "DELETE FROM products WHERE id =".concat(Integer.toString(id));
        System.out.println(q);
        executeCommitQuery(q);
    }
}