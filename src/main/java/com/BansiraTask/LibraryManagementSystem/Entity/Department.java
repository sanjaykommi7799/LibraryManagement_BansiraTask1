package com.BansiraTask.LibraryManagementSystem.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Departements")
public class Department {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_name")
    private Set<Book> books = new HashSet<>();

    public Department() {}
	public Department(String name, Set<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
    
    

}
