import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbHelper {
    private final  String username="root";
    private final String pasword="1234";
    private final String dburl="jdbc:mysql://localhost:3306/calculator";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dburl,username,pasword);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error:"+exception.getMessage());
        System.out.println("Error code:"+exception.getErrorCode());
    }
}
