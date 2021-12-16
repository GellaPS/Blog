package com.example.BlogEngine2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepo;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

	public Iterable<Category> getAllCategory() {
        return categoryRepo.findAll();
    }
	
	public Category getCategory(long id) {
        return categoryRepo.findById(id).get();
    }
	
	public void deleteCategory(Category category) {
		categoryRepo.delete(category);
	}
	
	public void save(Category category) {
		categoryRepo.save(category);
	}
	
	public Category create(Category category) {
        return this.categoryRepo.save(category);
    }
	
}
