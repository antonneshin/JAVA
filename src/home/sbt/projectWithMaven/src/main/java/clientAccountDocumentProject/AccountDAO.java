package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

/**
 * Created by Пентагон on 16.10.2016.
 */
public interface AccountDAO {
    public void setJBDC(JdbcTemplate jdbcT);
    public void addAccount(Long id, BigDecimal saldo, String accountNumber, Client client);
    public void addAccount(Account account);
    public Account getAccount(Long id);
    public void updateAccount(Account account);
}
