package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

/**
 * Created by Пентагон on 19.10.2016.
 */
public class AccountJDBC implements AccountDAO {
    private JdbcTemplate jdbcTemplate;
    public void setJBDC(JdbcTemplate jdbcT) {
        this.jdbcTemplate = jdbcT;
    }

    public void addAccount(Long id, BigDecimal saldo, String accountNumber, Client client) {
        jdbcTemplate.update("INSERT INTO accounts(ID, saldo, accountNumber, idClient) VALUES(?,?,?,?)",id,saldo,accountNumber,client.getId());
    }

    public void addAccount(Account account) {
        jdbcTemplate.update("INSERT INTO accounts(ID, saldo, accountNumber, idClient) VALUES(?,?,?,?)",
                account.getId(),account.getSaldo(),account.getAccountNumber(),account.getClient().getId()
        );
    }

    public Account getAccount(Long id) {
        Account account = jdbcTemplate.queryForObject("SELECT TOP 1 * FROM accounts WHERE id=?", new Object[]{id}, new AccountMapper());
        return account;
    }

    public void updateAccount(Account account){
        jdbcTemplate.update("UPDATE accounts SET saldo=?, accountNumber=? WHERE id=?",
                account.getSaldo(),account.getAccountNumber(),account.getId()
        );
    }
}

/*    CREATE TABLE accounts (
        id INTEGER,
        saldo INTEGER,
        accountNumber VARCHAR(100),
    idClient INTEGER
);*/
