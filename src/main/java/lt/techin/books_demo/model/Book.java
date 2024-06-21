package lt.techin.books_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String ISBN;
    private String photo;
    private int pagesCount;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public void addCategory(Category category){
        this.category = category;
         category.getBooks().add(this);
    }

    public void removeCategory() {
        this.category.getBooks().remove(this);
        this.category = null;
    }


}
