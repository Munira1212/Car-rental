import java.util.Scanner;

public class Cars extends DatabaseConnection{
    Scanner sc = new Scanner(System.in); //One Scanner to handled from user

    int choiseInput; //Input answer for either see car options or search after certain car brand
    String brandInput; //Input answer for which brand of car the user want
    int carPick;

    public void carSelection(String carType){
        System.out.println("Click 1.To see your options\n CLick 2. To search for a certain brand");
        choiseInput = sc.nextInt();

        switch(choiseInput) {
            case 1 ->
                    connectingSQL("SELECT car_id, car_brand, car_model, car_plate, car_first_registration, car_odometer FROM car_information WHERE " + carType + ">0",
                            new String[]{"Car ID", "Car brand:", "Car model:", "Car plate:", "Car first registration:", "Car odometer:"},
                            new String[]{"car_id","car_brand", "car_model", "car_plate", "car_first_registration", "car_odometer"});

            case 2 -> {
                System.out.println("Type the type of brand you would like?");
                brandInput= sc.next();
                connectingSQL("Select car_id, car_brand, car_model, car_plate, car_first_registration, car_odometer FROM car_information WHERE "+carType+ "> 0 AND car_brand LIKE " + "'%" + brandInput + "%'",
                        new String[]{"Car ID","Car brand:", "Car model", "Car plate", "Car first_registration", "car_odometer"},
                        new String[]{"car_id","car_brand", "car_model", "car_plate", "car_first_registration", "car_odometer"});
            }
        }
        costumersPick();
    }

    public void luxuryCar(){
        carSelection("luxury_car_id");
    }

    public void familyCar(){
        carSelection( "family_car_id");

    }
    public void sportsCar(){
        carSelection( "sport_car_id");
    }


    public void costumersPick(){
        System.out.println("Write the car ID of the car you wish to rent?");
        carPick = sc.nextInt();






        System.out.println("What is your renter_id? Click 1. To write your renter_id \n Click 2. If you dont remember");

        System.out.println("Write youre name");

        /*
        System.out.println("Write the number of the car you wish to rent?");
        choiseInput =sc.nextInt();
        connectingSQL("SELECT"+ choiseInput +"FROM car_information", new String[]{"Sorted by the " + choiseInput +" "},new String[]{"input"});

         */

    }








}
