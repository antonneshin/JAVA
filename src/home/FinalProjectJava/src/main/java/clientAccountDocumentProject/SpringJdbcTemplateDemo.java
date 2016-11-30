package clientAccountDocumentProject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Пентагон on 09.10.2016.
 */

public class SpringJdbcTemplateDemo {
    private JdbcTemplate jdbcTemplate;

    public SpringJdbcTemplateDemo(DriverManagerDataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void printAllClient(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM clients");
        for(Map<String,Object> oneElem : list){
            System.out.println(oneElem);
        }
    }

    public List<Client> loadAllClient(){
        List<Client> lsC = new LinkedList<Client>();
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM clients");
        for(Map<String,Object> oneElem : list){
            Client cl = new Client(new Long((Integer)oneElem.get("id")),(String)oneElem.get("name"));
            System.out.println(oneElem.get("id"));
            System.out.println(oneElem.get("name"));
            lsC.add(cl);
        }
        return lsC;
    }

    public void printClient(String name){
        Map<String, Object> clientDB = jdbcTemplate.queryForMap("SELECT * FROM clients WHERE name=?",name);
        System.out.println(clientDB);
    }

    public void insertClient(Client client){
        SqlParameterSource params = new BeanPropertySqlParameterSource(client);
        int result = jdbcTemplate.update("INSERT INTO clients(ID, NAME) VALUES(?,?)",client.getId(),client.getName());
        System.out.println(result==1? "OK" : "Fail");
    }

    //Account
    public void printAllAccounts(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM accounts");
        for(Map<String,Object> oneElem : list){
            System.out.println(oneElem);
        }
    }

    public List<Account> loadAllAccount(){
        List<Account> lsA = new LinkedList<Account>();
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM accounts");
        for(Map<String,Object> oneElem : list){
            Account ac = new Account(new Long((Integer)oneElem.get("id")),(BigDecimal)oneElem.get("saldo"),(String)oneElem.get("accountNumber"),null);
            System.out.println(oneElem.get("id"));
            System.out.println(oneElem.get("name"));
            lsA.add(ac);
        }
        return lsA;
    }

    public void printAccount(String acNumber){
        Map<String, Object> accountDB = jdbcTemplate.queryForMap("SELECT * FROM accounts WHERE accountNumber=?",acNumber);
        System.out.println(accountDB);
    }
//
//    public void insertAccount(Account account){
//        SqlParameterSource params = new BeanPropertySqlParameterSource(client);
//        int result = jdbcTemplate.update("INSERT INTO clients(ID, NAME) VALUES(?,?)",client.getId(),client.getName());
//        System.out.println(result==1? "OK" : "Fail");
//    }

}
