import java.util.Scanner;

public class RentalInformation extends DatabaseConnection {


    Scanner sc = new Scanner(System.in);
    private String userInput;

    public void rentedCars () {
        String query = "SELECT car_information.car_id, car_brand, car_model, car_plate, car_first_registration,renters_id, rental_start_date, rental_end_date\n" +
                "FROM car_information\n" +
                "INNER JOIN rental_contract ON car_information.car_id = rental_contract.car_id;";
        connectingSQL(query,new String [] {},new String [] {});
    }

    public void availabelCars () {
        String query = "SELECT car_information. *\n" +
                "FROM car_information\n" +
                "LEFT JOIN rental_contract ON car_information.car_id = rental_contract.car_id\n" +
                "WHERE rental_contract.car_id IS NULL;";
        connectingSQL(query,new String [] {},new String [] {});
    }

    public void prolongRental () {
        String query = "UPDATE rental_contract\n" +
                "SET rental_end_date =" + "'" + userInput + "'" + "\n" +
                "WHERE contract_id = " + userInput;
        executeDML(query, "The rental is now prolong to" + userInput);
    }

    public void EndRental () {
        String query = "DELETE FROM rental_contract WHERE contract_id =" + userInput;
        executeDML(query,"The rental is now prolong to" + userInput);
    }

    public void hh(){

    }
}
