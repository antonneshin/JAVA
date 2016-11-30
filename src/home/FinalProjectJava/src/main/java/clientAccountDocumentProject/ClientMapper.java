package clientAccountDocumentProject;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Пентагон on 16.10.2016.
 */
public class ClientMapper implements RowMapper<Client> {
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client(resultSet.getLong("id"),resultSet.getString("name"));
        return client;
    }
}
