package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;
	private String category_name;
	//M:N
	@ManyToMany(mappedBy = "categories")
	private Set<Book> books;
	
	public Category() {
		
	}

	public Category(int category_id, String category_name) {
		this.category_id = category_id;
		this.category_name = category_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
}
