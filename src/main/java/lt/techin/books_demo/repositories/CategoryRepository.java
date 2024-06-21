package lt.techin.books_demo.repositories;

import lt.techin.books_demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
