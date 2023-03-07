import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String menuItems;
    private int input;
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
                input = sc.nextInt();
                switch (input) {
                    case 1 -> carRental.luxuryCar();
                    case 2-> carRental.familyCar();
                    case 3-> carRental.sportsCar();
                    case 9 -> input=0;
                    default -> System.out.println("You typed something the system could not understand!");
                }
                //Register costumer her....
            }
            while (input!=0);
        } catch (InputMismatchException e) {
            System.out.println("ERROR 404");
        }
    }

}
