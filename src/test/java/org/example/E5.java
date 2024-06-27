package org.example;

import java.util.List;
import java.util.Map;

public class E5 {
    public static void main(String[] args){

        System.out.println(DBUtils.fetch("Select * from employee"));
        List<Map<String,String>> allData = DBUtils.fetch("Select * from employee");
        System.out.println(allData.get(0));  // LIST MAP --> any index of data we put from List of Maps
                                             // we get the Map from the List under this index

        Map<String,String> row1 = allData.get(0);  // Map --> any index of data we put from Map
        System.out.println(row1.get("salary"));    // and we get the ROW under this index from this particular Map
    }
}
