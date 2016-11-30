package hello;

import clientAccountDocumentProject.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Пентагон on 05.11.2016.
 */
@RestController
public class GreetingController {

    private ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
    private JdbcTemplate jdbcTemplate = new JdbcTemplate((DriverManagerDataSource)context.getBean("dataSource1"));
    private ClientJDBC clientJDBC = new ClientJDBC(jdbcTemplate);
    private AccountJDBC accountJDBC = new AccountJDBC(jdbcTemplate);
    private DocumentJDBC documentJDBC = new DocumentJDBC(jdbcTemplate);


    @RequestMapping("/client")
    public Client clientInfo(@RequestParam(value="id", required=false, defaultValue="") String clientId) {
        Client cl;
        try{
            cl = clientJDBC.getClient(new Long(clientId));
        } catch(Exception e) {
            cl = new Client(new Long(-1),"There is no such Client");
            System.out.println("GET SUCH ERROR--------------------------");
            e.printStackTrace();
        }
        return cl;
    }

    @RequestMapping("/account")
    public Account accountInfo(@RequestParam(value="id", required=false, defaultValue="") String accountId) {
        Account account;
        try{
            account = accountJDBC.getAccount(new Long(accountId));
        } catch(Exception e) {
            account = new Account(new Long(-1),new BigDecimal(-1),"There is no such Account",null);
            System.out.println("GET SUCH ERROR--------------------------");
            e.printStackTrace();
        }
        return account;
    }

    @RequestMapping("/documents")
    public Document documentInfo(@RequestParam(value="id", required=false, defaultValue="") String documentId) {
        Document document;
        try{
            document = documentJDBC.getDocument(new Long(documentId));
        } catch(Exception e) {
            document = new Document(new Long(-1),null,null,new BigDecimal(-1),"There is no such Document",null);
            System.out.println("GET SUCH ERROR--------------------------");
            e.printStackTrace();
        }
        return document;
    }

    @RequestMapping("/documents_client")
    public List<Document> documentListInfo(@RequestParam(value="id", required=false, defaultValue="") String clientId) {
        Client client = clientJDBC.getClient(new Long(clientId));
        List<Document> documents;
        try{
            documents = documentJDBC.getDocumentsByClient(client);
        } catch(Exception e) {
            documents =null;
            System.out.println("GET SUCH ERROR--------------------------");
            e.printStackTrace();
        }
        return documents;
    }
}
