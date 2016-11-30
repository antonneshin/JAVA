package hello;

/**
 * Created by Пентагон on 05.11.2016.
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
//for react
//C:\Users\Пентагон\Desktop\FinalProjectJava\src\main\reactjs>
