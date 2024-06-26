package lt.techin.books_demo.services;

import lt.techin.books_demo.exceptions.CategoryNotFoundException;
import lt.techin.books_demo.exceptions.DuplicateCategoriesException;
import lt.techin.books_demo.model.Category;
import lt.techin.books_demo.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        Optional<Category> category1 = this.categoryRepository.findByCategory(category.getCategory());
        if(category1.isPresent()){
            throw new DuplicateCategoriesException("Duplicate categories with description = "+category.getCategory());
        }
        return this.categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category category1 = this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Nu category with id = "+id));
        category1.setCategory(category.getCategory());
        return this.categoryRepository.save(category1);
    }

    public void deleteCategory(Long id) {
        Category category1 = this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Nu category with id = "+id));
        this.categoryRepository.delete(category1);
    }

    public Category getOneCategory(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Nu category with id = "+id));
    }
}
