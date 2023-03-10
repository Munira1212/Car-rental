import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    private int input;
    private boolean keeplaying = true;

    SubMenuAvailableCars subMenuAvailabelCars = new SubMenuAvailableCars();
    SubMenuRental subMenuRental = new SubMenuRental();
    SubMenuOrderOverview subMenuOrderOverview = new SubMenuOrderOverview();


    public void menuheader () {
        System.out.printf("  ———————————————————————————————————————————————————————————————————————————————————————————————————————————————%n");
        System.out.println("   K A I L U A    C A R      R E N T A L   " );
        System.out.println("  ———————————————————————————————————————————————————————————————————————————————————————————————————————————————");

        System.out.println();
        System.out.printf("  %-25s   %-30s    %5s %n","R E N T A L                          ","       A V A I L A B E L   C A R S ", "        O R D E R  O V E R V I E W       ");

        System.out.printf("  %-38s  %-37s %-50s ","Sign Up","       Luxury car  ",  "         Cancel rental  ");
        System.out.println();
        System.out.printf("   %-38s  %-37s %-50s ","\n  Add to basket         ","          Sports cars ","            Prolog rental");
        System.out.println();
        System.out.printf("   %-25s  %-37s","\n  Finalize order & sign contract", "               Family cars ");
        System.out.println();
        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println( "  I N F O R M A T I O N ");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n  Choose 1 (Rental)");
        System.out.println("  Choose 2 (Availble cars )");
        System.out.println("  Choose 3 (Order overview )");
        System.out.print("\n  Enter:");
    }

    public void readerchoiceoce(){
        try{
            while (keeplaying) {
                menuheader();
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        subMenuRental.rentalReaderChoice();
                        break;

                    case 2:
                        subMenuAvailabelCars.carsReaderChoice();
                        break;

                    case 3:
                        subMenuOrderOverview.OrderReaderChoice();
                        break;

                    default:
                        System.out.println("You typed something the system could not understand!");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Waring you wrote something our system dose not contain ");
        }
    }
}



