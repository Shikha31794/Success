import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    public class DBConfig {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/userdb"; // Change database name
             String username = "root";  // MySQL username
            String password = ""; // MySQL password

            try {
                // Establish Connection
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to Database Successfully!");

                // Create Statement
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM user"); // Replace with actual table

                // Print Data
                while (rs.next()) {
                    System.out.println("Username: " + rs.getString("username")
                            + ", Password: " + rs.getString("password"));
                }

                // Close Connection
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


//brew services start mysql
// mysql -u root

// String url = "jdbc:mysql://localhost:3306/userdb"; // Change database name
//            String user = "root";  // MySQL username
//            String password = ""; // MySQL password
//   mysql -h localhost -P 3306 -u root -p userdb

//Login with root user
// mysql -u root    pawwrsd empty
//created userdb
//created usrrs table
//Enter values user name and password

//https://chatgpt.com/c/67b994d3-8a00-8013-a33e-f1ff80154ad0
