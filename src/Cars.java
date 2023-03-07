import java.util.Scanner;

public class Cars extends DatabaseConnection{
    Scanner sc = new Scanner(System.in);
    String input;


    public void luxuryCar(){
        System.out.println("Click 1.To see your options\n CLick 2. To search for a certain brand");
        input=sc.nextLine();
        switch(input){
            case 1 -> connectingSQL("SELECT * FROM  ORDER BY " + input , new String[]{"Sorted by the " + input + " "},new String[]{input});
            case 2-> connectingSQL();
        }
        costumersPick();
    }

    public void familyCar(){
    }

    public void sportsCar(){
    }


    public void costumersPick(){
        System.out.println("Write the number of the car you wish to rent?");
        input=sc.nextLine();
        connectingSQL("SELECT"+input +"FROM artist", new String[]{"Sorted by the " + input +" "},new String[]{input});

    }








}
