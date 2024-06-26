package lt.techin.books_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateCategoriesException extends RuntimeException{

    public DuplicateCategoriesException(String message){
        super(message);
    }
}
