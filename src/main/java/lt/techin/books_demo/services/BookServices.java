package lt.techin.books_demo.services;

import lombok.AllArgsConstructor;
import lt.techin.books_demo.controllers.dto.CreateBookRequest;
import lt.techin.books_demo.exceptions.BookNotFoundException;
import lt.techin.books_demo.exceptions.CategoryNotFoundException;
import lt.techin.books_demo.model.Book;
import lt.techin.books_demo.model.Category;
import lt.techin.books_demo.repositories.BookRepository;
import lt.techin.books_demo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookServices {

    private final BookRepository bookRepository;


    private final CategoryRepository categoryRepository;




    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Long categoryId, CreateBookRequest createBookRequest) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("No such category with an id ="+categoryId));
        Book book = new Book();
        book.addCategory(category);
        book.setTitle(createBookRequest.getTitle());
        book.setDescription(createBookRequest.getDescription());
        book.setISBN(createBookRequest.getISBN());
        book.setPhoto(createBookRequest.getPhoto());
        book.setPagesCount(createBookRequest.getPagesCount());

        return this.bookRepository.save(book);
    }


    public Book updateBook(Long categoryId, Long id, CreateBookRequest book) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found by id = "+categoryId));

        Book book1 = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id = "+id));
        book1.setTitle(book.getTitle());
        book1.setDescription(book.getDescription());
        book1.setISBN(book.getISBN());
        book1.setPhoto(book.getPhoto());
        book1.setPagesCount(book.getPagesCount());
        book1.addCategory(category);
        return this.bookRepository.save(book1);
    }

    public void deleteBook(Long id) {
        Book book1 = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found with id = "+id));
        this.bookRepository.delete(book1);
    }

    public Set<Book> findAllBooksByCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found by id = "+categoryId));
        return category.getBooks();
    }
}
