package kwinta.gringotts;

import kwinta.gringotts.entities.Wizard;
import kwinta.gringotts.entities.Vault;
import kwinta.gringotts.entities.Transaction;
import kwinta.gringotts.dao.WizardRepository;
import kwinta.gringotts.dao.VaultRepository;
import kwinta.gringotts.dao.TransactionRepository;

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
public class GringottsController 
{
    @Autowired
    private WizardRepository wizardRepository;

    @Autowired
    private VaultRepository vaultRepository;

    @Autowired
    private TransactionRepository transactionRepository;
        
    // @GetMapping("/vault/{id}")
    // public ResponseEntity<Vault> getVault(@PathVariable("id") int id)
    // {
    //     Vault v = vaultRepository.findById(id).get();
    //     if(v == null)
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     return ResponseEntity.of(Optional.of(v));
    // }
    
    // @DeleteMapping("/books/{id}")
    // public ResponseEntity<Book> deleteBook(@PathVariable("id") int id)
    // {
    //     Book b = bookService.getBookByID(id);
    //     if(b == null)
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    //     bookService.deleteBookByID(id); 
    //     return ResponseEntity.status(HttpStatus.OK).build();
    // }

    // @PostMapping("/books")
    // public Book addBook(@RequestBody Book bookObject)
    // {
    //     Book b = bookService.addBook(bookObject);
    //     return b;
    // }
    
    // @PutMapping("/books/{id}")
    // public void updateBook(@RequestBody Book updatedBookObject, @PathVariable("id") int id)
    // {
    //     bookService.updateBookByID(updatedBookObject, id);   
    // }
} 
    