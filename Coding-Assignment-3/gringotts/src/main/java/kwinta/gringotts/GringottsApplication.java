package kwinta.gringotts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GringottsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GringottsApplication.class, args);
        System.out.println("The Bank has been opened!");
    }
}
