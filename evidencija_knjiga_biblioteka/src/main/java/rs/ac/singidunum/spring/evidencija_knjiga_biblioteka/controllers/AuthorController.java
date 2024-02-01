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
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.repositories.AuthorRepository;

@RestController
public class AuthorController {

	@Autowired
	private AuthorRepository repository;
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors(){
		return (List<Author>)repository.findAll();
	}
	
	@GetMapping("/authors/{id}")
	public Author getOneAuthor(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	
	@PostMapping("/authors")
	public Author addAuthor(@RequestBody Author author) {
		return repository.save(author);
	}
	
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/authors/{id}")
	public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
		return repository.save(author);
	}
	
	
	//M:N
	@GetMapping("/authors/book")
	public List<Author> getAuthorsByBook(@RequestBody Book book){
		return repository.findAllAuthorsByBooks(book);
	}
	
	
	
}
