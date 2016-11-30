package clientAccountDocumentProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Пентагон on 16.10.2016.
 */
public class AccountMapper implements RowMapper<Account> {
    private ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
    private ClientJDBC clientJDBC = new ClientJDBC();
    public AccountMapper(){
        clientJDBC.setJBDC(new JdbcTemplate((DriverManagerDataSource)context.getBean("dataSource1")));
    }
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Client c=clientJDBC.getClient(resultSet.getLong("idClient"));
        Account account = new Account(resultSet.getLong("id"),resultSet.getBigDecimal("saldo"),resultSet.getString("accountNumber"),c);
        return account;
    }
}
