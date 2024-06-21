package lt.techin.books_demo.controllers;

import jakarta.validation.Valid;
import lt.techin.books_demo.controllers.dto.CreateBookRequest;
import lt.techin.books_demo.model.Book;
import lt.techin.books_demo.model.Category;
import lt.techin.books_demo.services.BookServices;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping
public class BookControllers {

    private BookServices bookServices = null;

    public BookControllers(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("/api/books")
    public List<Book> getAllBooks(){
        return bookServices.getAllBooks();
    }

    @PostMapping("/api/categories/{categoryId}/books")
    public ResponseEntity<?> createBook(@PathVariable Long categoryId, @Valid @RequestBody CreateBookRequest book){

        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookServices.createBook(categoryId, book));
    }

    @PutMapping("/api/categories/{categoryId}/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long categoryId, @PathVariable Long id, @RequestBody CreateBookRequest book){
        return ResponseEntity.ok(this.bookServices.updateBook(categoryId, id, book));
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id){
        this.bookServices.deleteBook(id);
    }

    @GetMapping("/api/categories/{categoryId}/books")
    public Set<Book> getAllBooksByCategory(@PathVariable Long categoryId){
        return this.bookServices.findAllBooksByCategory(categoryId);
    }

}













