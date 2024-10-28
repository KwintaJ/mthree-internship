package kwinta.app;

import  java.util.*;
import org.springframework.stereotype.Component;

@Component
public class BookService
{
    List<Book> bookData;

    public BookService()
    {
        bookData = new ArrayList<Book>();
    }

    public void createDatabase()
    {
        bookData.add(new Book(101, "Harry Potter", "J. K. Rowling"));
        bookData.add(new Book(102, "The Lord of the Rings",  "J. R. R. Tolkien"));
        bookData.add(new Book(103, "Ender's Game", "O. S. Card"));
    }

    public List<Book> getAllBooks()
    {
        return bookData;
    }

    public Book getBookById(int id)
    {
        return bookData.get(id);
    }
}   