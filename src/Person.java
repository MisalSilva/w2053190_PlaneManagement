public class Person {
    //Attributes
    private String name;
    private String surname;
    private String email;

    //constructor
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Getter and setter for name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //Getter and setter for surname
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    //Getter and setter for email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    //method for printing person information
    public void printPersonInfo(){
        System.out.println("Name is " + name);
        System.out.println("Surname is " + surname);
        System.out.println("Email is " + email);
    }
}
