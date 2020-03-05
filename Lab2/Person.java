package lab2;

//Person object with constructor, accessors and mutators
public class Person
{
    private String name;
    private String surname;
    private int age;
    private long identityNumber;
    private String type;
    
    public Person(String name, String surname, int age, long identityNumber, String type){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.identityNumber = identityNumber;
        this.type = type;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSurname(String surname){
        surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setIdentityNumber(long identityNumber){
        this.identityNumber = identityNumber;
    }
    public long getIdentityNumber(){
        return this.identityNumber;
    }
    public void setType(String name){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
