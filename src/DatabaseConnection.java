import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static final String database_url ="jdbc:mysql://localhost:3306/Kailua_rental";
    public static java.sql.Connection con; //erklærer vores connection her

    public void connectingSQL(String statement, String[] msg, String[]column){
        try {
            con = DriverManager.getConnection(database_url, "root", "sesame80"); ////adressen, brugernavn, kode
            Statement s = con.createStatement(); //indholder vores sql query
            String sql = statement;

             ResultSet rs = s.executeQuery(sql);
            if (rs != null){
                while (rs.next()) { //Skiller resultatset ad i dataen
                    for (int i = 0; i <column.length ; i++) {
                        // kode løber gennem rækkerne i et SQL query result og udskriver de angivne kolonner med den tilsvarende besked for hver række.
                        System.out.println(msg[i] + rs.getString(column[i])); //
                    }
                }
            }

        }catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());
            System.exit(1);
        }
}
    public void executeDML(String statement, String msg){
        String query = statement;
        try  {
            con = DriverManager.getConnection(database_url, "root", "sesame80");
            Statement s = con.createStatement();
            s.executeUpdate(query);


            System.out.println(msg);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
