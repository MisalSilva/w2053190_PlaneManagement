import java.util.InputMismatchException;
    import java.util.Scanner;
    public class w2053190_PlaneManagement {
        static Scanner input = new Scanner(System.in);
        //Define 2D Array to represent the seating plan of the plane
        static int[][] seat_plan = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}
        };
        static int option;
        static boolean correct = false;
        static int max_seat_num;
        static double price;

        //Define an array to store ticket information
        static Ticket[] tickets = new Ticket[100];
        static int ticketCount = 0;

        //Method to display menu options and get user input for option
        static void menu_options(){
            correct = false;
            while(!correct){
                try{
                    for (int i = 0; i < 50; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    System.out.println("*                  MENU OPTIONS                 *");
                    for (int i = 0; i < 50; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    System.out.println("     1) Buy a seat");
                    System.out.println("     2) Cancel a seat");
                    System.out.println("     3) Find first available seat");
                    System.out.println("     4) Show seating plan");
                    System.out.println("     5) Print tickets information and total sales");
                    System.out.println("     6) search ticket");
                    System.out.println("     0) Quit");
                    for (int i = 0; i < 50; i++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    System.out.print("Please select an option : ");
                    option  = input.nextInt();
                    //set correct to true if input is valid
                    correct = true;
                }
                catch(InputMismatchException e){
                    //handling invalid input
                    System.out.println("Invalid Input");
                    input.nextLine();
                    correct = false;
                }
            }
        }
        //Method to buy a seat
        static void buy_method() {
            char row_letter = 0;
            int seat_num = 0;
            boolean correct = false;

            while (!correct) {
                try {
                    //prompting for row letter
                    System.out.print("Enter Row Letter: ");
                    //using toUpperCase so that simple characters converts to capital
                    row_letter = input.next().toUpperCase().charAt(0);
                    //checks if the row_letter entered by the user is within the valid range of seat rows
                    if (row_letter < 'A' || row_letter > 'D') {
                        System.out.println("Invalid Row Letter. Please enter A, B, C, or D.");
                        buy_method();
                    }
                    correct = true;
                }
                catch (InputMismatchException e) {
                    //handling invalid input
                    System.out.println("Invalid Row Letter, please try again");
                    input.nextLine();
                }

                try {
                    System.out.print("Enter Seat Number: ");
                    seat_num = input.nextInt();
                    int max_seat_num;
                    //assigning values to max_seat_num according to the row letter
                    if (row_letter == 'B' || row_letter == 'C')
                        max_seat_num =  12;
                    else {
                        max_seat_num = 14;
                    }
                    //checking seat_num if within valid range of seat numbers
                    if (seat_num >= 1 && seat_num <= max_seat_num){
                        correct = true;
                    }
                    else {
                        System.out.println("Invalid seat number. Please enter between 1 and " + max_seat_num + ".");
                        input.nextLine();
                        continue;
                    }
                    correct = true;
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid Seat Number, please try again");
                    input.nextLine();
                }
            }
            //prompting for person information
            input.nextLine();
            System.out.print("Enter person's name: ");
            String name = input.nextLine();
            System.out.println();
            System.out.print("Enter person's surname: ");
            String surname = input.nextLine();
            System.out.print("Enter person's email: ");
            String email = input.nextLine();
            //new person object
            Person person = new Person(name, surname, email);
             //assign price values according to the seats
            if (seat_num >= 1 && seat_num <= 5){
                double price = 200.0;
            }
            else if (seat_num >= 6 && seat_num <= 9){
                double price = 150.0;
            }
            else if (seat_num >= 10 && seat_num <= max_seat_num){
                double price = 180.0;
            }
            //new ticket object
            Ticket ticket = new Ticket(String.valueOf(row_letter), seat_num, price, person);
             tickets[ticketCount] = ticket;
             ticketCount++;


            int row_index = row_letter - 'A';
            int seat_index = seat_num - 1;

            if (seat_plan[row_index][seat_index] == 1) {
                System.out.println("Seat " + row_letter + seat_num + " is already occupied.");
            }
            else {
                seat_plan[row_index][seat_index] = 1;
                System.out.println("Seat " + row_letter + seat_num + " bought Successfully.");
            }
            //calling save method in the ticket class
            ticket.save();
        }
        //Method to cancel a seat
        static void cancel_seat() {
            char row_letter = 0;
            int seat_num = 0;
            boolean correct = false;

            while (!correct) {
                try {
                    //prompting for row letter
                    System.out.print("Enter Row Letter: ");
                    //using toUpperCase so that simple characters converts to capital
                    row_letter = input.next().toUpperCase().charAt(0);
                    if (row_letter < 'A' || row_letter > 'D') {
                        //checks if the row_letter entered by the user is within the valid range of seat rows
                        System.out.println("Invalid Row Letter. Please enter A, B, C, or D.");
                        return;
                    }
                    correct = true;
                }
                catch (InputMismatchException e) {
                    //handling invalid input
                    System.out.println("Invalid Row Letter, please try again");
                    input.nextLine();
                }

                try {
                    System.out.print("Enter Seat Number: ");
                    seat_num = input.nextInt();
                    int max_seat_num;
                    //assigning values to max_seat_num according to the row letter
                    if (row_letter == 'B' || row_letter == 'C')
                        max_seat_num =  12;
                    else {
                        max_seat_num = 14;
                    }
                    //checking seat_num if within valid range of seat numbers
                    if (seat_num >= 1 && seat_num <= max_seat_num){
                        correct = true;
                    }
                    else {
                        System.out.println("Invalid seat number. Please enter between 1 and " + max_seat_num + ".");
                        return;
                    }
                    correct = true;
                }
                catch (InputMismatchException e) {
                    //handling invalid input
                    System.out.println("Invalid Seat Number, please try again");
                    input.nextLine();
                }
            }
            boolean found = false;
            for (int i =0; i < ticketCount; i++){
                //locating the row and seat
                Ticket ticket = tickets[i];
                if (ticket.getRow().charAt(0) == row_letter && ticket.getSeat() == seat_num){
                    for (int j = 0; j < ticketCount - 1; j++){
                        tickets[j] = tickets[j + 1];
                    }
                    //once located it will be removed from the array
                    ticketCount--;
                    found = true;

                    int row_index = row_letter - 'A';
                    int seat_index = seat_num - 1;

                    if (seat_plan[row_index][seat_index] == 0) {
                        System.out.println("Seat " + row_letter + seat_num + " is already available.");
                    }
                    else {
                        seat_plan[row_index][seat_index] = 0;
                        System.out.println("Seat " + row_letter + seat_num + " cancelled Successfully.");
                    }
                }
                if (!found){
                    //if not located error message will be rinted
                    System.out.println("Tickets not found for seat " + row_letter + seat_num);
                }
            }
        }
        //method to find the first available seat
        static void find_first_available(){
            String[] rows = {"A", "B", "C", "D"};
            int[] seats = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
            boolean found = false;

            //goes through the whole array and checks the first available seat
            for (int i = 0; i<4; i++){
                for (int j = 0; j< seats.length; j++){
                    if (seat_plan[i][j] == 0){
                        System.out.println("The first available seat is "+rows[i]+seats[j]);
                        found = true;
                        break;
                    }
                }
                //once the available seat is found will break form the loop
                if (found){
                    break;
                }
            }
            //if not found error message will be printed
            if (!found){
                System.out.println("There are no seats available.");
            }
        }
        //method to print the seating plan
        static void show_seating_plan(){
            for (int i = 0; i<4; i++){
                for (int j = 0;j < seat_plan[i].length; j++){
                    if (seat_plan[i][j] == 0){
                        System.out.print("O ");
                    }
                    else if(seat_plan[i][j] == 1){
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        //method to print ticket information
        static void print_tickets_info(){
            double totalAmount = 0.0;

            System.out.println("Tickets sold during the session: ");
            for (int i = 0; i < ticketCount; i++){
                Ticket ticket = tickets[i];
                System.out.println("Ticket " + (i + 1) + ".");
                ticket.printTicketInfo();
                totalAmount += ticket.getPrice();
            }
            System.out.println("Total amount: £" + totalAmount);
        }
        //method to search tickets
        static void search_tickets(){
            char row_letter = 0;
            int seat_num = 0;
            boolean correct = false;

            while (!correct) {
                try {
                    System.out.print("Enter Row Letter: ");
                    row_letter = input.next().toUpperCase().charAt(0);
                    if (row_letter < 'A' || row_letter > 'D') {
                        System.out.println("Invalid Row Letter. Please enter A, B, C, or D.");
                        return;
                    }
                    correct = true;
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid Row Letter, please try again");
                    input.nextLine();
                }

                try {
                    System.out.print("Enter Seat Number: ");
                    seat_num = input.nextInt();
                    int max_seat_num;
                    if (row_letter == 'B' || row_letter == 'C')
                        max_seat_num =  13;
                    else {
                        max_seat_num = 14;
                    }
                    if (seat_num >= 1 && seat_num <= max_seat_num){
                        correct = true;
                    }
                    else {
                        System.out.println("Invalid seat number. Please enter between 1 and " + max_seat_num + ".");
                        return;
                    }
                    correct = true;
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid Seat Number, please try again");
                    input.nextLine();
                }
            }
            boolean found = false;
            for (int i =0; i < ticketCount; i++) {
                Ticket ticket = tickets[i];
                if (ticket.getRow().charAt(0) == row_letter && ticket.getSeat() == seat_num) {
                    System.out.println("Ticket Information: ");
                    ticket.printTicketInfo();
                    found = true;
                    break;
                }
            }
            if (!found){
                System.out.println("This seat is available.");
            }
        }

        public static void main(String[]args){
            System.out.println("Welcome to the Plane Management Application");
            while(true){
            menu_options();

            switch(option){
                case 1: buy_method(); break;
                case 2: cancel_seat(); break;
                case 3: find_first_available(); break;
                case 4: show_seating_plan(); break;
                case 5: print_tickets_info(); break;
                case 6: search_tickets(); break;
                case 0: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid Option. Please try again."); break;
                }
            }
        }
    }
