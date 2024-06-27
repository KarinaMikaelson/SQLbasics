package org.example;
import java.sql.*;

public class E3 {
    public static void main(String[] args) throws SQLException {

        // The proper way to extract data from tables

        // A db url string it contains all the required info to connect to any database
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql ";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
            Statement statement = connection.createStatement();
            String query = "Select * from person";

            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData rsm = resultSet.getMetaData();
             for(int i = 1; i <= rsm.getColumnCount(); i++){       // for loop --> gives us names of all columns
                 System.out.print(rsm.getColumnLabel(i)+" ");
             }
            System.out.println();

            // extract data from database
            while(resultSet.next()){
                for(int i = 1; i <= rsm.getColumnCount(); i++){
                    System.out.print(resultSet.getString(i)+" ");  // Use resultSet --> to get actual data
                }
                System.out.println();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
