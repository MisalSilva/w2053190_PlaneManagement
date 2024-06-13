import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Ticket {
    //Attributes
    private String row;
    private int seat;
    private double price;
    private Person person;

    //constructor
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getter and setter for row
    public String getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = String.valueOf(row);
    }

    //getter and setter for seat
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    //getter and setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //getter and setter for person
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    //method for printing seat information and person information
    public void printTicketInfo() {
        System.out.println("Row is " + row);
        System.out.println("Seat is " + seat);
        System.out.println("Price is " + price);
        System.out.println("Person information is: ");
        person.printPersonInfo();
    }

    //method for saving ticket and person information when buying a seat
    public void save() {
        String fileName = this.getRow() + this.getSeat() + ".txt";
        try (FileWriter writer = new FileWriter(row + "" + seat + ".txt")) {
            writer.write("Ticket Information of seats" + "\n");
            writer.write("\t Row " + getRow() + "\n");
            writer.write("\t Seat " + getSeat() + "\n");
            writer.write("\t Price £ " + getPrice() + "\n");
            writer.write("\t Person Information: " + "\n");
            writer.write("\t First name: " + person.getName() +
                    "\n");
            writer.write("\t Surname: " + person.getSurname() +
                    "\n");
            writer.write("\t Email: " + person.getEmail() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
