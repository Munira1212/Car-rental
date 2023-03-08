import java.util.Date;
import java.util.Scanner;

public class CostumersReg extends DatabaseConnection {
    Scanner sc = new Scanner(System.in);
    Scanner in = new Scanner(System.in);

    public void createRenter() {
        System.out.println("What is your renter id?");
        int renters_id = sc.nextInt();
        System.out.println("What is your name ?");
        String renters_name = in.nextLine();
        System.out.println("what is your address?");
        String renters_address = in.nextLine();
        System.out.println("What is your zip?");
        int renters_zip = sc.nextInt();
        System.out.println("What is your phone number?");
        int renters_phone = sc.nextInt();
        System.out.println("what is your licensnumber");
        int renters_license_number = sc.nextInt();
        System.out.println("Driven licens since date?");
        String renters_driver_since_date = in.nextLine();

        executeDML("INSERT INTO renters (renters_id, renters_name, renters_address, renters_zip, renters_phone, renters_license_number, renters_driver_since_date) VALUES (" +
                "'" + renters_id + "', '" + renters_name + "', '" + renters_address + "', " + renters_zip + ", " + renters_phone + ", " + renters_license_number + ", '" + renters_driver_since_date + "')"
    ,"Your are now registret in tyhe system. Your renter id " + renters_id );
    }


   public void carRenter(){



   }

}
