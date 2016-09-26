package src.lesson_21;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Student on 26.09.2016.
 */
public class Logger implements Runnable {
    Connection conn;
    String str;
    public void setStr(String newStr){
        this.str=newStr;
    }

    @Override
    public void run() {
        PreparedStatement preparedStatement = null;
        try {
            this.conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
            preparedStatement = conn.prepareStatement("INSERT INTO log (str) VALUES (?)");

            preparedStatement.setString(1, this.str);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
