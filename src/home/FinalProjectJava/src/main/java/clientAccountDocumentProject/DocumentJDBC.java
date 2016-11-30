package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Пентагон on 23.10.2016.
 */
public class DocumentJDBC implements DocumentDAO {
    private JdbcTemplate jdbcTemplate;
    private AccountJDBC accountJDBC;

    public DocumentJDBC(){
        this.jdbcTemplate = null;
        this.accountJDBC = null;
    }

    public DocumentJDBC(JdbcTemplate jdbcT) {
        this.jdbcTemplate = jdbcT;
        this.accountJDBC = new AccountJDBC();
        this.accountJDBC.setJBDC(jdbcT);
    }

    public void setJDBC(JdbcTemplate jdbcT) {
        this.jdbcTemplate = jdbcT;
        this.accountJDBC = new AccountJDBC();
        this.accountJDBC.setJBDC(jdbcT);
    }

    public void addDocument(Document document) {
        Account sender = document.getAccDT();
        Account reciver = document.getAccCT();
        sender.setSaldo(sender.getSaldo().subtract(document.getSumma()));
        accountJDBC.updateAccount(sender);
        reciver.setSaldo(reciver.getSaldo().add(document.getSumma()));
        accountJDBC.updateAccount(reciver);
        jdbcTemplate.update("INSERT INTO documents(id,accDT,accCT,summa,purpose,docDate) VALUES(?,?,?,?,?,?)",
                document.getId(),document.getAccDT().getId(),document.getAccCT().getId(),
                document.getSumma(),document.getPurpose(),document.getDocDate()
        );

    }

    public Document getDocument(Long id) {
        Document document = jdbcTemplate.queryForObject("SELECT TOP 1 * FROM documents WHERE id=?", new Object[]{id}, new DocumentMapper());
        return document;
    }

    public List<Document> getDocumentsByClient(Client client){
        List<Document> lsDoc = new LinkedList<Document>();
        lsDoc = jdbcTemplate.query("SELECT documents.* FROM documents JOIN accounts \n" +
                "             ON documents.accCt=accounts.id OR documents.accDt=accounts.id\n" +
                "                JOIN clients ON clients.id=accounts.idclient\n" +
                "               WHERE clients.id=?",
                new Object[]{client.getId()},new DocumentMapper());
        return lsDoc;
    }
}
