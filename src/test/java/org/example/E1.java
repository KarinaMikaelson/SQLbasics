package org.example;
import java.sql.*;

public class E1 {
    public static void main(String[] args) throws SQLException {
//           A db url string it contains all the required info to connect to any database
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql ";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

//         Creates a connection to the database
        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
            /*
            take the queries from java code execute them on the database and bring the results back
            into your java program.
             */
            Statement statement = connection.createStatement();
            String query = "Select * from person";
            ResultSet resultSet = statement.executeQuery(query);
//          We need a loop to go thue the rows
//          next() checks if there are any more rows in the ResultSet
//          if yes, it returns true
//          and moves the cursor to the next row

//          extract data from database
        while(resultSet.next()){
            String firstname = resultSet.getString("FirstName"); // hardcoded name of column
            int age = resultSet.getInt("age");
            String city = resultSet.getString("city");
            System.out.println(firstname+" "+age+" "+city);
        }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
