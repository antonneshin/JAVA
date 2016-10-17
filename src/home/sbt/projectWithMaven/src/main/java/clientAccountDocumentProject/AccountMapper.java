package clientAccountDocumentProject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Пентагон on 16.10.2016.
 */
public class AccountMapper {
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account(resultSet.getLong("id"),resultSet.getBigDecimal("saldo"),resultSet.getString("accountNumber"),clientJDBC.getClient(resultSet.getLong("client")));
        return account;
    }
}
