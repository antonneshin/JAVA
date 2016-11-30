package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Пентагон on 23.10.2016.
 */
public interface DocumentDAO {
    public void setJDBC(JdbcTemplate jdbcT);
    public void addDocument(Document document);
    public Document getDocument(Long id);
    public List<Document> getDocumentsByClient(Client client);
}
