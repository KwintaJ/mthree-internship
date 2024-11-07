package kwinta.gringotts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * cc by Jan Kwinta Nov 2024
 * 
 * This is a web application of
 * Gringott's Wizarding Bank
 * 
 * For more information check README
 * mvn spring-boot:run
 */
@SpringBootApplication
public class GringottsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GringottsApplication.class, args);
        System.out.println("The Bank has been opened!");
    }
}
