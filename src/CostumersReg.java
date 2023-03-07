import java.util.Date;
import java.util.Scanner;

public class CostumersReg extends DatabaseConnection {

    Scanner sc = new Scanner(System.in);
    public void createRental(String name, String adress, int zip, String city, String phone, String email, String driver_licenser_number, Date driver ){
        connectingSQL("Insert into" + name + adress + zip + city + phone + email+ driver_licenser_number + driver, new String [] {"You have now been registered "}, new String [] {name} );
    }

    public void rentalCar(String ){

    }











}
