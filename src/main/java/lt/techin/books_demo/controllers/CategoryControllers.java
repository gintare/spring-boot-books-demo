package lt.techin.books_demo.controllers;

import jakarta.websocket.server.PathParam;
import lt.techin.books_demo.model.Category;
import lt.techin.books_demo.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categories")
public class CategoryControllers {

    private final CategoryServices categoryServices;

    public CategoryControllers(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return this.categoryServices.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryServices.createCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category){
        return ResponseEntity.ok(this.categoryServices.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        this.categoryServices.deleteCategory(id);
    }

    @GetMapping("/{id}")
    public Category getOneCategory(@PathVariable Long id) {
        return this.categoryServices.getOneCategory(id);
    }

}
