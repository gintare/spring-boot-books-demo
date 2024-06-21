package lt.techin.books_demo.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException (String error){
        super(error);
    }
}
