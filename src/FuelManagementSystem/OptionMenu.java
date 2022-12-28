package FuelManagementSystem;
import java.util.Scanner;

public class OptionMenu {
    Scanner sc = new Scanner(System.in);



    public void MainMenuDisplay()  {
        boolean userIntReceived = false;
        int Choice;

        System.out.format("%n%n****************************************************************************%n");
        System.out.format("                             MAIN MENU                                %n");
        System.out.format("+***************************************************************************%n");
        System.out.format("%n%n       1. MANAGE CUSTOMERS                                              %n");
        System.out.format("       2. PAYMENTS                                               %n");
        System.out.format("       3. MANAGE QUEUES                                     %n");
        System.out.format("       4. MANAGE DISPENSERS                            %n");
        System.out.format("       5. MANAGE DATABASE                                                   %n");
        System.out.format("       6. VIEW STATS                                                      %n");
        System.out.format("       0. EXIT                                                            %n");

        System.out.println();
        while (!userIntReceived) {
            try {
                System.out.print("PLEASE SELECT YOUR OPTION : ");
                Choice = Integer.parseInt(sc.nextLine());
                userIntReceived = true;
                switch (Choice) {
                    case 1 -> manageCustomers();
                    case 2 -> System.out.println("option2");
                    case 3 -> System.out.println("option3");
                    case 4 -> System.out.println("option4");
                    case 5 -> System.out.println("option5");
                    case 6 -> System.out.println("option 6");
                    case 0 -> System.exit(0);

                    default -> MainMenuDisplay();
                }
            } catch (Exception e) {System.out.println("Error");}
        }

    }


    public void manageCustomers() {
        boolean userIntReceived = false;
        int Choice;

        System.out.format("%n%n****************************************************************************%n");
        System.out.format("                             MANAGE CUSTOMER MENU                                %n");
        System.out.format("+***************************************************************************%n");
        System.out.format("%n%n       1. ENTER CUSTOMER DETAILS                                           %n");
        System.out.format("       2. VIEW CUSTOMER DETAILS                                               %n");
        System.out.format("       0. EXIT TO MAIN MENU                                                            %n");


        System.out.println();
        while (!userIntReceived) {
            try {
                System.out.print("PLEASE SELECT YOUR OPTION : ");
                Choice = Integer.parseInt(sc.nextLine());
                userIntReceived = true;
                switch (Choice) {
                    case 1 -> {
                        System.out.println("\n------ CUSTOMER DETAILS ENTRY ------\n");

                        System.out.print("ENTER FUEL TYPE: ");
                        String fuelType = sc.next();

                        System.out.print("ENTER FUEL AMOUNT: ");
                        double fuelInput = sc.nextDouble();

                        System.out.print("ENTER VEHICLE TYPE: ");
                        String vehicleType = sc.next();

                        System.out.print("ENTER CUSTOMER NAME: ");
                        String customerName = sc.next();


                        Customer customer = new Customer(fuelType, fuelInput, false, vehicleType, customerName, null);

                        manageCustomers();

                    }
                    case 2 -> System.out.println("DISPLAY CUSTOMER DETAILS");
                    case 0 -> MainMenuDisplay();

                    default -> manageCustomers();
                }
            } catch (Exception e) {System.out.println("Error");}
        }

        }


        public static void main (String[]args){


            System.out.println("        ***********************************************************");
            System.out.println("                  WELCOME TO THE FUEL MANAGEMENT SYSTEM          ");
            System.out.println("        ***********************************************************");

            OptionMenu op = new OptionMenu();
            op.MainMenuDisplay();




        }
    }