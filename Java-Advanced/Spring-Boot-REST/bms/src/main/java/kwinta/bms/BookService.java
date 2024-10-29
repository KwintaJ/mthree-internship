package kwinta.bms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class BookService 
{
    private static List<Book> myBookList  = new ArrayList<Book>();
    static
    {
        myBookList.add(new Book(101, "Anton", "Java in Simple way"));
        myBookList.add(new Book(102, "Jose", "Java in Simple way2"));
        myBookList.add(new Book(103, "Anton", "Java in Simple way3"));
    }
    
    public List<Book> getAllBooks()
    {
        return myBookList;
    }
    
    public Book getBookByID(int id)
    {
        Book book = null;
        book = myBookList.stream().filter(b -> b.getId() == id).findFirst().get();
        return book;
    }

    public void deleteBookByID(int id) 
    {
        myBookList = myBookList.stream().filter(b -> b.getId() != id).collect(Collectors.toList());
    }

    public void updateBookByID(Book updatedBookObject, int id) 
    {
        myBookList.stream().map(b -> {
            if (b.getId() == id) {
                b.setAuthor(updatedBookObject.getAuthor());
                b.setTitle(updatedBookObject.getTitle());
            }
            
            return b;
        }).collect(Collectors.toList());
    }

    public Book addBook(Book bookObject) 
    {
        myBookList.add(bookObject);
        return bookObject;
    } 
}