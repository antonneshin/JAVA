package src.lesson_21;

import java.sql.*;

/**
 * Created by Student on 19.09.2016.
 */
public class main {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM songs");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" song name = "+resultSet.getString("name")+" time = "+resultSet.getBigDecimal(4));
            }

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Songs WHERE id = ?");
            preparedStatement.setString(1,"25");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" song name = "+resultSet.getString("name")+" time = "+resultSet.getBigDecimal(4));
            }


        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
