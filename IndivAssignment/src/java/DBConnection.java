import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            con = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/StudentProfilesDB",
                    "app",
                    "app"
            );

            System.out.println("Database Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
