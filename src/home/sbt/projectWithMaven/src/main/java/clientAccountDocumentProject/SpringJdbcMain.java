package clientAccountDocumentProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.activation.DataSource;
import javax.print.Doc;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * Created by Пентагон on 09.10.2016.
 */
@Configuration
public class SpringJdbcMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        SpringJdbcTemplateDemo jdbc = (SpringJdbcTemplateDemo)context.getBean("jdbcTemp");
        jdbc.printAllClient();
        Client one = (Client)context.getBean("firstClient");
        System.out.println("one name = "+one.getName());

        ClientJDBC clientJDBC = new ClientJDBC();
        clientJDBC.setJBDC(new JdbcTemplate((DriverManagerDataSource)context.getBean("dataSource1")));
        Client cl=clientJDBC.getClient(new Long(4));
        System.out.println("client name = "+cl.getName());
        AccountJDBC accountJDBC = new AccountJDBC();
        accountJDBC.setJBDC(new JdbcTemplate((DriverManagerDataSource)context.getBean("dataSource1")));
        accountJDBC.addAccount(new Long(1),new BigDecimal(777),"123456798",cl);
        cl.setName("not Alone Wolf");
        clientJDBC.updateClient(cl);
        Account account = accountJDBC.getAccount(new Long(1));
        System.out.println(account.getId()+" "+account.getAccountNumber()+" "+account.getSaldo()+"\n"+"client inf "+account.getClient().getId()+" "+account.getClient().getName());

        account.setSaldo(account.getSaldo().subtract(new BigDecimal(77)));
        accountJDBC.updateAccount(account);
        System.out.println(account.getId()+" "+account.getAccountNumber()+" "+account.getSaldo()+"\n"+"client inf "+account.getClient().getId()+" "+account.getClient().getName());

        DocumentJDBC documentJDBC = new DocumentJDBC();
        documentJDBC.setJDBC(new JdbcTemplate((DriverManagerDataSource)context.getBean("dataSource1")));

        //Document newDoc = new Document(new Long(1),account,account,new BigDecimal(33),"fakeManipulationWithMoney",new Date());
        //documentJDBC.addDocument(newDoc);
//        Document sameDoc = documentJDBC.getDocument(new Long(1));
//        System.out.println("document = "+sameDoc.getId()+" purpose="+sameDoc.getPurpose()+" fromCT_saldo="+sameDoc.getAccCT().getSaldo());

//        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Пентагон\\Desktop\\JAVAnew\\src\\home\\sbt\\projectWithMaven\\src\\main\\resources\\springContext.xml");
//        SpringJdbcTemplateDemo jdbc = (SpringJdbcTemplateDemo)context.getBean("jdbcDemo");/*
//
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcMain.class);
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:h2:tcp://localhost/~/test","sa","");
        //dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setPassword("");
        dataSource.setUsername("sa");

        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource)//new JdbcTemplate(dataSource);
        SpringJdbcTemplateDemo jdbc = new SpringJdbcTemplateDemo(dataSource);
        jdbc.printAllClient();

        //jdbc.printClient("bIG bOSS");
        Client newCL = new Client(new Long(4),"Alone Wolf");
        jdbc.insertClient(newCL);

        List<Client> lsC=jdbc.loadAllClient();
        for(Client c : lsC){
            System.out.println("client name="+c.getName()+" id="+c.getId());
        }*/
        JdbcTemplate jdbcTemplate = new JdbcTemplate((DriverManagerDataSource)context.getBean("dataSource1"));
        ClientJDBC clientDB = new ClientJDBC();
        clientDB.setJBDC(jdbcTemplate);
        AccountJDBC accountDB = new AccountJDBC();
        accountDB.setJBDC(jdbcTemplate);
        DocumentJDBC documentDB = new DocumentJDBC();
        documentDB.setJDBC(jdbcTemplate);
/*
        Client c1 = new Client(new Long(33),"Professor Qsavue");
        clientDB.addClient(c1);
        Account acc1 = new Account(new Long(33),new BigDecimal(1000),"33-33",c1);
        accountDB.addAccount(acc1);

        Client c2 = new Client(new Long(44),"Magnetto");
        clientDB.addClient(c2);
        Account acc2 = new Account(new Long(44),new BigDecimal(2000),"44-44",c2);
        accountDB.addAccount(acc2);

        Document d1 = new Document(new Long(3344),acc1,acc2,new BigDecimal(500),"from Professor To Magnetto",new Date());

        documentDB.addDocument(d1);*/

        Client c1 = new Client(new Long(33),"Professor Qsavue");
        List<Document> lsD = documentDB.getDocumentsByClient(c1);
        System.out.println("size="+lsD.size());
        for (Document d: lsD){
            System.out.println(d.getId()+"|"+d.getSumma()+"|"+d.getPurpose());
        }



    }
}
