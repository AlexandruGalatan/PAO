package lab2;

//Create and show info about Subject
public class Ex4{
    public static void main(String[] args)
    {
        Room classroom1 = new Room("12A", "normal", 3);
        Room classroom2 = new Room("12A", "normal", 3);
        
        Person teacher1 = new Person("John", "Doe", 30, 100, "teacher");
        Person teacher2 = new Person("Jane", "Doe", 30, 100, "teacher");
        
        Subject sub1 = new Subject(classroom1, 20, teacher1);
        Subject sub2 = new Subject(classroom2, 30, teacher2);
        
        System.out.println(sub1.getTeacher().getName());
        System.out.println(sub1.getRoom().getNumber());
        
        System.out.println(sub2.getTeacher().getName());
        System.out.println(sub2.getRoom().getNumber());
    }
}