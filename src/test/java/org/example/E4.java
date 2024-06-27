package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class E4 {
    public static void main(String[] args) throws SQLException {

        // Creating List of Maps

        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql ";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(dbURL, userName, password);
            Statement statement = connection.createStatement();
            String query = "Select * from person";

            ResultSet resultSet = statement.executeQuery(query);    // resultSet contains the Values
            ResultSetMetaData rsm = resultSet.getMetaData();        // meta data contains the KEYS
            List<Map<String, String>> tableData = new ArrayList<>();

             for(int i = 1; i <= rsm.getColumnCount(); i++){
                 System.out.print(rsm.getColumnLabel(i)+" ");
             }
            System.out.println();

            while(resultSet.next()){
                Map<String,String> rowMap = new LinkedHashMap<>();
                for(int i = 1; i <= rsm.getColumnCount(); i++){
                    String key = rsm.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);
            }
            System.out.println(tableData);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
