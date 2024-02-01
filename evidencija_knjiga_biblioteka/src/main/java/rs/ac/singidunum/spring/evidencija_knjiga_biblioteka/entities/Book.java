package rs.ac.singidunum.spring.evidencija_knjiga_biblioteka.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	private String title;
	private int publication_year;
	private int copies_owned;
	private String language;
	private int pages;
	//M:N
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_author",
				joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
				inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id")
			  )
	private Set<Author> authors;
	
	//M:N
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_category",
				joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
				inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id")
			  )
	private Set<Category> categories;
	
	
	public Book() {
		
	}
	
	public Book(int book_id, String title, int publication_year, int copies_owned, String language, int pages) {
		this.book_id = book_id;
		this.title = title;
		this.publication_year = publication_year;
		this.copies_owned = copies_owned;
		this.language = language;
		this.pages = pages;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublication_year() {
		return publication_year;
	}

	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}

	public int getCopies_owned() {
		return copies_owned;
	}

	public void setCopies_owned(int copies_owned) {
		this.copies_owned = copies_owned;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	
	
	
	
}
