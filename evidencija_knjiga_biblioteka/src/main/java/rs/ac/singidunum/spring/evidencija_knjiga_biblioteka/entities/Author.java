package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name= "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int author_id;
	private String first_name;
	private String last_name;
	//M:N
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;
	
	public Author() {
		
	}
	
	public Author(int author_id, String first_name, String last_name) {
		this.author_id = author_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	
}
