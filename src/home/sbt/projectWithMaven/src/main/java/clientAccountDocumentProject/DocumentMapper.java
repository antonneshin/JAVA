package clientAccountDocumentProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Пентагон on 23.10.2016.
 */
public class DocumentMapper implements RowMapper<Document> {
    private ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
    private AccountJDBC accountJDBC = new AccountJDBC();

    public DocumentMapper() {
        accountJDBC.setJBDC(new JdbcTemplate((DriverManagerDataSource) context.getBean("dataSource1")));
    }

    public Document mapRow(ResultSet resultSet, int i) throws SQLException {
        Account accDT = accountJDBC.getAccount(resultSet.getLong("accDT"));
        Account accCT = accountJDBC.getAccount(resultSet.getLong("accCT"));
        Document document = new Document(resultSet.getLong("id"), accDT, accCT, resultSet.getBigDecimal("summa"), resultSet.getString("purpose"), resultSet.getDate("docDate"));
        return document;
    }
}
