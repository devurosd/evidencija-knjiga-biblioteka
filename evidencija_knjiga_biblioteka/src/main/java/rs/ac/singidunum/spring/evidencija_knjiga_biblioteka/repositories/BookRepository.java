package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Author;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Book;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Category;

public interface BookRepository extends CrudRepository<Book, Integer> {

	List<Book> findAllBooksByAuthors(Author author);		//M:N
	List<Book> findAllBooksByCategories(Category category);	//M:N
	
	List<Book> findByLanguageIgnoreCase(String language);	//pretraga po jeziku
	
	
}
