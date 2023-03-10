import java.sql.SQLException;
import java.util.Scanner;
public class CostumersReg extends DatabaseConnection {
    Scanner sc = new Scanner(System.in);
    Scanner in = new Scanner(System.in);




    public void createRenter() throws SQLException {
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

        String query= "INSERT INTO renters (renters_id, renters_name, renters_address, renters_zip, renters_phone, renters_license_number, renters_driver_since_date) VALUES (" +
                "'" + renters_id + "', '" + renters_name + "', '" + renters_address + "', " + renters_zip + ", " + renters_phone + ", " + renters_license_number + ", '" + renters_driver_since_date + "')";

        executeDML(query,"Your are now registret in tyhe system. Your renter id " + renters_id );

    }
       public void rentalContrct () throws SQLException {

           System.out.println("What's your Rental ID?");
           int renters_id = sc.nextInt();



           System.out.println("What you car_id");
           int car_id= sc.nextInt();

           System.out.println("What date do you want to start the rental? ");
           String rental_start_date = in.next();

           System.out.println("And when do the rental end?");
           String rental_end_date = in.next();

           System.out.println("The current Km?");
           int rental_start_km = sc.nextInt();

           System.out.println("The max km for the renter to use?");
           int rental_maximum_km = sc.nextInt();

           String insertQuery = "INSERT INTO rental_contract (car_id, renters_id, rental_start_date, rental_end_date, rental_maximum_km, rental_start_km) VALUES (" +
                car_id + ", " + renters_id + ", '" + rental_start_date + "', '" + rental_end_date + "', " + rental_maximum_km + ", " + rental_start_km + ")";


           executeDML(insertQuery, "Rental contract created with contract ID: ");
           System.out.println(insertQuery);
           connectingSQL("SELECT contract_id FROM rental_contract WHERE renters_id =" + renters_id, new String[]{"contract id"}, new String[]{"contract_id"});
           con.close();
       }

   }
