import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/courses";
        String username = "root";
        String password = "Sunny@007";

        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");

        while(resultSet.next()){
            System.out.print(resultSet.getInt(1)+" - ");
            System.out.print(resultSet.getInt(2)+" - ");
            System.out.println(resultSet.getString(3));
        }

        connection.close();
        System.out.println("Connection Established");

    }
}
