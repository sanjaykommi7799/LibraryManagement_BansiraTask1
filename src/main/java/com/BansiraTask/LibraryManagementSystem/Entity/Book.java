package com.BansiraTask.LibraryManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Book {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String ISBN;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private String department;
    private boolean available;
    public Book() {}
	public Book(String iSBN, String title, String author, String genre, int publicationYear, String department) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.publicationYear = publicationYear;
		this.department = department;
		this.available = true;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", genre=" + genre
				+ ", publicationYear=" + publicationYear + ", department=" + department + ", available=" + available
				+ "]";
	}
	
    
}
