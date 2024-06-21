package lt.techin.books_demo.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String error){
        super(error);
    }
}
