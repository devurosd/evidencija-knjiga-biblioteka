package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Book;
import rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	List<Category> findAllCategoriesByBooks(Book book);	//M:N
}
