package lab2;

//Create and show info about Person
public class Ex2{
    public static void main(String[] args)
    {
        Person John = new Person("John", "Doe", 20, 100, "student");
        Person Jane = new Person("Jane", "Doe", 20, 100, "student");
        System.out.println(John.getName());
        System.out.println(Jane.getName());
    }
}