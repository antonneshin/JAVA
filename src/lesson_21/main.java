package src.lesson_21;

import java.sql.*;

/**
 * Created by Student on 19.09.2016.
 */
public class main {
    public static void main(String[] args) {
        /*try{
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
        }*/

        try{
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
//            System.out.println("TYPE_FORWARD_ONLY="+conn.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
//
//            System.out.println("TYPE_SCROLL_INSENSITIVE="+conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
//
//            System.out.println("TYPE_SCROLL_SENSITIVE="+conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM songs");
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1)+" song name = "+resultSet.getString("name")+" time = "+resultSet.getBigDecimal(4));
//            }

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO songs (name) VALUES (?)");


            /*Logger log = new Logger();
            log.setStr("azazaSong");
            Thread t = new Thread(log);
            t.start();
            try{
                t.join();
            }catch (Exception e){
                e.printStackTrace();
            }*/
            Savepoint mySave = conn.setSavepoint("MY_FIRST_SAVE_POINT");


            preparedStatement.setString(1,"azazaSong");
            preparedStatement.executeUpdate();
            conn.rollback(mySave);

            preparedStatement.setString(1,"hohohoSong");
            preparedStatement.executeUpdate();
            conn.commit();

        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
