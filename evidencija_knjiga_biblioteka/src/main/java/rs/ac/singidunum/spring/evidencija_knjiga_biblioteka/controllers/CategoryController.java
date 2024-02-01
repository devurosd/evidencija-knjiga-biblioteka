package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Book;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Category;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository repository;
	
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		return (List<Category>)repository.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public Category getOneCategory(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return repository.save(category);
	}
	
	@DeleteMapping("/categories/{id}")
	public void deleteCategory(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/categories/{id}")
	public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
		return repository.save(category);
	}
	
	//M:N
	@GetMapping("/categories/book")
	public List<Category> getCategoriesByBook(@RequestBody Book book){
		return repository.findAllCategoriesByBooks(book);
	}
}
