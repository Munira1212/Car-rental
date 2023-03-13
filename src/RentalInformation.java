import java.util.Scanner;

public class RentalInformation extends DatabaseConnection {


    Scanner sc = new Scanner(System.in);
    private String userInput;

    public void rentedCars() {
        String query = "SELECT rental_end_date\n" +
                "FROM car_information\n" +
                "INNER JOIN rental_contract ON car_information.car_id = rental_contract.car_id;";
        connectingSQL(query,new String [] {"The end of the rental"},new String [] {"rental_end_date"});
    }

    public void availalbeCars () {
        String query = "SELECT car_information.*\n" +
                "FROM car_information\n" +
                "LEFT JOIN rental_contract ON car_information.car_id = rental_contract.car_id\n" +
                "WHERE rental_contract.car_id IS NULL;";
        connectingSQL(query, new String[]{"rental_contract.renters_id", "rental_contract.car_id", "car_information.car_brand", "car_information.car_model", "car_information.car_plate", "car_information.car_first_registration", "rental_contract.rental_start_date", "rental_contract.rental_end_date", "rental_contract.rental_maximum_km", "rental_contract.rental_start_km"}, new String[]{"rental_contract.renters_id", "rental_contract.car_id", "car_information.car_brand", "car_information.car_model", "car_information.car_plate", "car_information.car_first_registration", "rental_contract.rental_start_date", "rental_contract.rental_end_date", "rental_contract.rental_maximum_km", "rental_contract.rental_start_km"});

    }

    public void prolongRental () {
        String query = "UPDATE rental_contract\n" +
                "SET rental_end_date =" + "'" + userInput + "'" + "\n" +
                "WHERE contract_id = " + userInput;
        //executeDML(query, "The rental is now prolong to" + userInput);
    }

    public void EndRental () {
        String query = "DELETE FROM rental_contract WHERE contract_id =" + userInput;
        executeDML(query,"The rental is now prolong to" + userInput);
    }

    public void hh(){

    }
}
