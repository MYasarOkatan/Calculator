import java.sql.*;
import java.util.ArrayList;

public class dataOperate {
    private static Connection connection = null;
   private static PreparedStatement statement = null;
    private static final dbHelper database = new dbHelper();
    private static ResultSet resultSet;
    public void datainsert(double number, String sing) throws SQLException {
   try {
        connection = database.getConnection();
        String sql = "insert into calculator.calculator(number,sign) values(?, ?);";
        statement = connection.prepareStatement(sql);
        statement.setDouble(1, number);
        statement.setString(2, sing);
        statement.executeUpdate();
    } catch (SQLException e) {
        database.showErrorMessage(e);
    } finally {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}
    public void dataupdate(double number1,int number2) throws SQLException {
        String sql = "update calculator.calculator set number= ? where id=?  ";
        try {connection = database.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setDouble(1, number1);
            statement.setInt(2, number2);
            statement.executeUpdate();
        } catch (
                SQLException e) {
            database.showErrorMessage(e);
        } finally {
            connection.close();
            statement.close();
        }
    }
    public void datadelete(int number) throws SQLException {
        String sql = "delete from calculator.calculator where id=(?); ";
        try {connection = database.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, (number));
            statement.executeUpdate();
        } catch (
                SQLException e) {
            database.showErrorMessage(e);
        } finally {
            statement.close();
            connection.close();
        }
    }
    public  void  alldelete() throws SQLException {
        try{ connection =database.getConnection();
            String sql="delete from calculator.calculator;";
            statement =connection.prepareStatement(sql);
            statement.executeUpdate();
        }catch (SQLException e){
            database.showErrorMessage(e);
        }
        finally {

            statement.close();
            connection.close();
        }
    }
    public ArrayList<data> dataarray() throws SQLException {
        Statement statement1;
        ArrayList<data> data=new ArrayList<data>();
        connection=database.getConnection();
        statement1=connection.createStatement();
        resultSet=statement1.executeQuery("select * from calculator");
        while (resultSet.next()){
            data.add(new data(resultSet.getDouble("number"),
                    resultSet.getString("sign"),
                    (int) resultSet.getDouble("id")));
        }
        return data;
    }
}

