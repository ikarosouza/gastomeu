package br.com.reiosse.gastomeu.service.impl;

import br.com.reiosse.gastomeu.exception.ResourceNotFoundException;
import br.com.reiosse.gastomeu.model.Category;
import br.com.reiosse.gastomeu.repository.CategoryRepository;
import br.com.reiosse.gastomeu.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", id));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", id));
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setType(category.getType());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category", "id", id));
        categoryRepository.delete(category);
    }
}
