package src.home.sbt.task21_2209;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Пентагон on 22.09.2016.
 */class Square{
    private Map<Integer, Integer> hashRes = new HashMap<>();
    private Connection conn;
    private Statement statement;

    public Square() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hashRes");
            while(resultSet.next()){
                //System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
                hashRes.put(resultSet.getInt("squareNum"),resultSet.getInt("squareRes"));
            }
            // add application code here
            statement.close();
            resultSet.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getResult (int number){
        if(hashRes.get(number)!=null){
            System.out.println("from DB:");
            return hashRes.get(number);
        }
        Integer res = number*number;
        hashRes.put(number,res);
        try {
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO hashRes(squareNum, squareRes) VALUES(?,?)");
            preparedStatement.setInt(1,number);
            preparedStatement.setInt(2,res);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println("2*2 = "+square.getResult(2));
        System.out.println("3*3 = "+square.getResult(3));
        System.out.println("4*4 = "+square.getResult(4));
    }
}
