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

    public void carType() throws SQLException {
        System.out.println("what car type do you want?");
        int answar = sc.nextInt();
        switch (answar) {
            case 1 -> luxuryCar();
            case 2 -> familyCar();
            case 3 -> sportsCar();
        }

    }
        public void choseCar() throws SQLException {
            System.out.println("Write the ID of the car you wish to rent?");
            int car_id = in.nextInt();
            in.nextLine(); // consume the newline character

            System.out.println("What is your renters_ID:");
            String renters_id = in.nextLine();

            Statement s = con.createStatement();
            // Check om car_id eller renters_id allerede exister
            String query = "SELECT * FROM rental_contract WHERE car_id = " + car_id + " OR renters_id = '" + renters_id + "'";
            ResultSet rs = s.executeQuery(query);

            if (rs.next()) {
                if (rs.getInt("car_id") == car_id) {
                    System.out.println("The car you wish for is currently reserved by someone else. Would you like to proceed anyways and hurry to sign the contract to secure the car(Y/N)? )");
                } else {
                    System.out.println("The renters_id you have entered already exists. Do you wish to enter another one? (Y/N)");
                }
                String answer = in.nextLine();
                if (!answer.equalsIgnoreCase("Y")) {
                    return;
                }
            } else {
                // hvis b??de car_id og renters_id ikke exist, insert into database
                query = "INSERT INTO rental_contract (car_id, renters_id) VALUES (" + car_id + ", '" + renters_id + "')";
                executeDML(query, "Rental contract created with contract ID: ");
                System.out.println(query);
            }
        }
}

