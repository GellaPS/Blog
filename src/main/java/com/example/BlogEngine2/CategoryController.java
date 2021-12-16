package com.example.BlogEngine2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
	
	@RequestMapping(value = "/newCategory", method = RequestMethod.POST)
    public String createCategory(Category category) {
		categoryService.save(category);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/editCategory/{id}", method = RequestMethod.GET)
    public String editCategoryWithId(Long id, Model model) {
    	Category category = categoryService.getCategory(id);
        model.addAttribute("ctgry", category);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public String deleteCategoryWithId(Long id) {
    	Category category = categoryService.getCategory(id);
    	categoryService.deleteCategory(category);
        return "redirect:/";
    }
	
}
