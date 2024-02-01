package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Author;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Book;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

	List<Author> findAllAuthorsByBooks(Book book);	//M:N
	
}
