package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Пентагон on 16.10.2016.
 */
public class ClientJDBC implements ClientDAO {
    private JdbcTemplate jdbcTemplate;
    public void setJBDC(JdbcTemplate jdbcT) {
        this.jdbcTemplate = jdbcT;
    }

    public void addClient(Long id, String name) {
        jdbcTemplate.update("INSERT INTO clients(ID, NAME) VALUES(?,?)",id,name);
    }

    public Client getClient(Long id) {
        Client client = jdbcTemplate.queryForObject("SELECT * FROM clients WHERE id=?", new Object[]{id}, new ClientMapper());
        return client;
    }
}
