package clientAccountDocumentProject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by Пентагон on 09.10.2016.
 */
@Configuration
public class SpringJdbcMain {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcMain.class);
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:h2:tcp://localhost/~/test","sa","");
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
        }


    }
}
