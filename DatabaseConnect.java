import java.sql.*;

public class DatabaseConnect {
    public static void main (String[]args) {

        Connection connect = null;
        String url = "jdbc:mysql://localhost/employees?user=root&password=YAGMUR123";
        Statement statement = null;
        try {
            connect = DriverManager.getConnection(url);
            statement = connect.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM employees");

            while (data.next()) {
                int id = data.getInt("id");
                String name = data.getString("name");
                String position = data.getString("position");
                int salary = data.getInt("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
            }

            data.close();
            statement.close();
            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}