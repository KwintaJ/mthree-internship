package kwinta.app;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController
{
    @GetMapping("/initialize")
    public String createDatabase()
    {
        BookService serv = new BookService();
        List<Book> list = serv.createDatabase();

        return list.get(1).toString();
    }
}