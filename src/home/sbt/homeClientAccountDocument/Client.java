package src.home.sbt.homeClientAccountDocument;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Пентагон on 28.09.2016.
 */
public class Client {
    private Long id;
    private String name;
    public Client(Long newId, String newName) {
        this.id = newId;
        this.name = newName;
        loadClientInDB(newId,newName);
    }
    private void loadClientInDB(Long newId, String newName){
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO clients (id, name) VALUES (?,?)");
            preparedStatement.setLong(1,newId);
            preparedStatement.setString(2,newName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
