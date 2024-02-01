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

import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Author;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Book;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Category;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.repositories.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return (List<Book>)repository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book getOneBook(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return repository.save(book);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
		return repository.save(book);
	}
	
	
	//M:N
	@GetMapping("/books/author")
	public List<Book> getBooksByAuthor(@RequestBody Author author){
		return repository.findAllBooksByAuthors(author);
	}
	
	//M:N
	@GetMapping("/books/category")
	public List<Book> getBooksByCategory(@RequestBody Category category){
		return repository.findAllBooksByCategories(category);
	}
	
	//pretraga po jeziku - vracanje liste svih knjiga napisanih na odredjenom jeziku
	@GetMapping("/books/search/{language}")
	public List<Book> getBooksByYear(@PathVariable String language){
		return repository.findByLanguageIgnoreCase(language);
	}
	

	

}
