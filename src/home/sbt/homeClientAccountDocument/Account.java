package src.home.sbt.homeClientAccountDocument;

import src.home.sbt.taskChat.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Пентагон on 29.09.2016.
 */
public class Account {
    private Long id;
    private BigDecimal saldo;
    private String accountNumber;
    private Client client;

    public Account(Long id, BigDecimal saldo, String accountNumber, Client client) {
        this.id = id;
        this.saldo = saldo;
        this.accountNumber = accountNumber;
        this.client = client;
        loadAccountInDB(id, saldo, accountNumber, client);
    }

    private void loadAccountInDB(Long id, BigDecimal saldo, String accountNumber, Client client) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO accounts(id, saldo, accountNumber, idClient) VALUES (?,?,?,?)");
            preparedStatement.setLong(1,id);
            preparedStatement.setBigDecimal(2,saldo);
            preparedStatement.setString(3,accountNumber);
            preparedStatement.setLong(4,client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Client getClient() {
        return client;
    }
}
