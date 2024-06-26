package lt.techin.books_demo.repositories;

import lt.techin.books_demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Query(value = "SELECT * from Category c where c.category=?1")
//    public List<Category> findByCategory(String category);


    Optional<Category> findByCategory(String category);


}
