package lt.techin.books_demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name="book_id")
    Book book;

    public void addBook(Book book){
        this.book = book;
        book.getComments().add(this);
    }

    public void removeBook(){
        this.book.getComments().remove(this);
        this.book = null;
    }
}
