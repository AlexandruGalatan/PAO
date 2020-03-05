package lab2;
//Subject object with constructor, accessors and mutators
public class Subject
{
    Room room;
    int noOfStudents;
    Person teacher;
    
    public Subject(Room room, int noOfStudents, Person teacher){
        this.room = room;
        this.noOfStudents = noOfStudents;
        this.teacher = teacher;
    }
    
    public void setRoom(Room room){
        this.room = room;
    }
    
    public Room getRoom(){
        return this.room;
    }
    
    public void setNoOfStudents(int noOfStudents){
        this.noOfStudents = noOfStudents;
    }
    
    public int getNoOfStudents(){
        return this.noOfStudents;
    }
    
    public void setTeacher(Person teacher){
        this.teacher = teacher;
    }
    
    public Person getTeacher(){
        return this.teacher;
    }
}
