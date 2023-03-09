import java.sql.*;
import java.util.Scanner;

public class Cars extends DatabaseConnection {
    Scanner sc = new Scanner(System.in); //One Scanner to handled from user
    Scanner in = new Scanner(System.in);
    private int chooseInput; //Input answer for either see car options or search after certain car brand
    private String brandInput; //Input answer for which brand of car the user want
    private int carPick;

    public void carSelection(String carType) throws SQLException {
        System.out.println("Click 1.To see your options\n CLick 2. To search for a certain brand");
        chooseInput = sc.nextInt();

        switch (chooseInput) {
            case 1 ->
                    connectingSQL("SELECT car_id, car_brand, car_model, car_plate, car_first_registration, car_odometer FROM car_information WHERE " + carType + ">0",
                            new String[]{"Car ID", "Car brand:", "Car model:", "Car plate:", "Car first registration:", "Car odometer:"},
                            new String[]{"car_id", "car_brand", "car_model", "car_plate", "car_first_registration", "car_odometer"});

            case 2 -> {
                System.out.println("Type the type of brand you would like?");
                brandInput = sc.next();
                connectingSQL("Select car_id, car_brand, car_model, car_plate, car_first_registration, car_odometer FROM car_information WHERE " + carType + "> 0 AND car_brand LIKE " + "'%" + brandInput + "%'",
                        new String[]{"Car ID", "Car brand:", "Car model", "Car plate", "Car first_registration", "car_odometer"},
                        new String[]{"car_id", "car_brand", "car_model", "car_plate", "car_first_registration", "car_odometer"});
            }
        }

        costumersPick();

    }

    public void luxuryCar() throws SQLException {
        carSelection("luxury_car_id");
    }

    public void familyCar() throws SQLException {
        carSelection("family_car_id");

    }

    public void sportsCar() throws SQLException {
        carSelection("sport_car_id");
    }

    public void costumerPick(){
        System.out.println("Write the ID of the car you wish to rent?");
        int car_id = in.nextInt();
        in.nextLine(); // Consume the newline character
        System.out.println("What is your name:");
        String renters_name = in.nextLine();
        String sql = "INSERT INTO rental_contract(car_id) VALUES (" +
                car_id + ")";
    }

    public void pickCar() throws SQLException {
        System.out.println("Write the ID of the car you wish to rent?");
        int car_id = in.nextInt();
        in.nextLine(); // Consume the newline character

        System.out.println("What is your name:");
        String renters_name = in.nextLine();

        String query = "INSERT INTO car_information (car_id, rental_start_date, rental_end_date, rental_maximum_km, rental_start_km, renters_id) " +
                "VALUES ('" + car_id + "', NULL, NULL, NULL, NULL, " +
                "(SELECT renters_id FROM renters WHERE renters_name = '" + renters_name + "'))";
        executeDML(query, "Rental contract created");

        System.out.println(query);
    }







    public void costumersPick() throws SQLException {
        System.out.println("Write the ID of the car you wish to rent?");
        int car_id = sc.nextInt();

        String query = "INSERT INTO rental_contract(car_id, renters_id, rental_start_date) VALUES (" +
                car_id + ", LAST_INSERT_ID(), CURRENT_DATE)";
        executeDML(query, "You are registered");

        Statement statement = con.createStatement();
        statement.executeUpdate(query);

        ResultSet rs = statement.executeQuery("SELECT LAST_INSERT_ID() AS renters_id");
        rs.next();
        int renters_id = rs.getInt("renters_id");

        System.out.println("Rental contract created with contract ID: " + renters_id);
    }
}






}





