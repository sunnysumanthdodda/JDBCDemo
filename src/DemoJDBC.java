import java.sql.*;

public class DemoJDBC {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/courses";
        String username = "root";
        String password = "Sunny@007";

        Connection connection = DriverManager.getConnection(url,username,password);
        System.out.println("Connection Established");

        PreparedStatement preparedStatement = connection.prepareStatement("insert into student values (?,?,?)");
        preparedStatement.setInt(1,8);
        preparedStatement.setInt(2,82);
        preparedStatement.setString(3,"Sai Krishna");
        preparedStatement.execute();

        //statement.execute("insert into student values (4,90,'Sai Ram')");
        ResultSet resultSet = preparedStatement.executeQuery("select * from student");

        while(resultSet.next()){
            System.out.print(resultSet.getInt(1)+" - ");
            System.out.print(resultSet.getInt(2)+" - ");
            System.out.println(resultSet.getString(3));
        }

        connection.close();
        System.out.println("Connection closed");

    }
}
