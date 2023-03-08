import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String menuItems;
    private int userInput;

    //Scanner
    Scanner sc = new Scanner(System.in);
    public Menu(String menuHeader, String leadText, String menuItems){
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }
    public void printMenu() {
        System.out.println(menuHeader);
        System.out.println(leadText);
        System.out.println(menuItems);
    }

    Cars carRental = new Cars();
    public void readchoice(){
        try{
            do  {
                printMenu();
                userInput = sc.nextInt();
                switch (userInput) {
                    case 1 -> carRental.luxuryCar();
                    case 2-> carRental.familyCar();
                    case 3-> carRental.sportsCar();
                    case 4-> costumersReg.createRenter();
                    case 9 -> userInput =0;
                    default -> System.out.println("You typed something the system could not understand!");
                }
                costumersReg.carRenter();
            }
            while (userInput !=0);
        } catch (InputMismatchException e) {
            System.out.println("ERROR 404");
        }
    }

}
