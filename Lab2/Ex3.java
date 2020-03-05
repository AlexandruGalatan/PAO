package lab2;

//Create and show info about Room
public class Ex3{
    public static void main(String[] args)
    {
        Room a = new Room("12A", "normal", 3);
        Room b = new Room("12B", "tech", 7);
        
        System.out.println(a.getNumber());
        System.out.println(b.getNumber());
    }
}