package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Пентагон on 16.10.2016.
 */
public interface ClientDAO {
    public void setJBDC(JdbcTemplate jdbcT);
    public void addClient(Long id, String name);
    public void addClient(Client client);
    public void updateClient(Client client);
    public Client getClient(Long id);
}
