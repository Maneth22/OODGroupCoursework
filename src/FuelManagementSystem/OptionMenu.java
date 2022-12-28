package FuelManagementSystem;
import java.io.IOException;
import java.util.Scanner;


public class OptionMenu{
    Scanner sc = new Scanner(System.in);
    int Choice = -1;
    public void MainMenuDisplay() throws IOException {


        System.out.println("        ***********************************************************");
        System.out.println("                  WELCOME TO THE FUEL MANAGEMENT SYSTEM          ");
        System.out.println("        ***********************************************************");

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
        System.out.print("PLEASE SELECT YOUR OPTION : ");
        optionSelect();

    }
    public void optionSelect()throws IOException, StackOverflowError {
            try {
                Choice = sc.nextInt();
                switch (Choice) {
                    case 1 -> System.out.println("option1");
                    case 2 -> System.out.println("option2");
                    case 3 -> System.out.println("option3");
                    case 4 -> System.out.println("option4");
                    case 5 -> System.out.println("option5");
                    case 6 -> System.out.println("option6");
                    case 0 -> System.exit(0);
                    default -> {
                        System.out.print("INVALID RESPONSE | PLEASE ENTER A VALID RESPONSE:  ");
                        optionSelect();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error Occurred"+e);
            }


        optionSelect();

    }



    public static void main(String[] args) throws Exception {

    OptionMenu op = new OptionMenu();
    op.MainMenuDisplay();

    }
}