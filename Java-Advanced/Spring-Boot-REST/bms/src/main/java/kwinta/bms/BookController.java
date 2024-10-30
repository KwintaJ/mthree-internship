package kwinta.bms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController 
{
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> b = bookService.getAllBooks();
        if (b.size() <=0)
        {
            System.out.println(b);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }
        
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookBasedOnId(@PathVariable("id") int id)
    {
        Book b = bookService.getBookByID(id);
        if(b == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(b));
    }
    
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id)
    {
        bookService.deleteBookByID(id); 
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book bookObject)
    {
        Book b = bookService.addBook(bookObject);
        return b;
    }
    
    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book updatedBookObject, @PathVariable("id") int id)
    {
        bookService.updateBookByID(updatedBookObject, id);   
    }
} 
    