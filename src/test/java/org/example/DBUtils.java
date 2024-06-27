package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    // Create a CommonMethod
    // Constants has been moved to Constants Class
    public static List<Map<String,String>> fetch(String query){

        List<Map<String, String>> tableData = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(Constants.DB_URL,Constants.USER_NAME,Constants.PASSWORD);
            Statement statement = connection.createStatement();
            //String query = "Select * from person";        ----> will be provided by the user

            ResultSet resultSet = statement.executeQuery(query);    // resultSet contains the Values
            ResultSetMetaData rsm = resultSet.getMetaData();        // meta data contains the KEYS

            while(resultSet.next()){
                Map<String,String> rowMap = new LinkedHashMap<>();
                for(int i = 1; i <= rsm.getColumnCount(); i++){
                    String key = rsm.getColumnLabel(i);
                    String value = resultSet.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return tableData;
    }

}
