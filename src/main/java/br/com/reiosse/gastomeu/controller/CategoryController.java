package br.com.reiosse.gastomeu.controller;

import br.com.reiosse.gastomeu.exception.ResourceNotFoundException;
import br.com.reiosse.gastomeu.model.Category;
import br.com.reiosse.gastomeu.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) throws ResourceNotFoundException {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) throws ResourceNotFoundException {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) throws ResourceNotFoundException {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

