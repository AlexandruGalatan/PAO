package lab2;
//Room object with constructor, accessors and mutators
public class Room
{
    String number;
    String type;
    int floor;
    
    public Room(String number, String type, int floor){
        this.number = number;
        this.type = type;
        this.floor = floor;
    }
    
    public void setNumber(String number){
        this.number = number;
    }
    
    public String getNumber(){
        return this.number;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setFloor(int floor){
        this.floor = floor;
    }
    
    public int getFloor(){
        return this.floor;
    }
}
