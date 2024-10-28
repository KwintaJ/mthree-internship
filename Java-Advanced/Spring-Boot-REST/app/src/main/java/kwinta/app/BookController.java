package kwinta.app;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookController
{
    BookService serv;

    @GetMapping("/books/initialize")
    public String createDatabase()
    {
        serv = new BookService();
        serv.createDatabase();

        return "database created";
    }

    @GetMapping("/books/get/{id}")
    public String getBookOnId(@PathVariable("id") int id)
    {
        Book b = serv.getBookById(id);
        return b.toString();
    }
}