package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Пентагон on 16.10.2016.
 */
public interface AccountDAO {
    public void setJBDC(JdbcTemplate jdbcT);
    public void addAccount(Long id, String name);
    public Account getAccount(Long id);
}
