package com.BansiraTask.LibraryManagementSystem.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BansiraTask.LibraryManagementSystem.Entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, String>{

	
	public List<Book> findBookByTitle(String title);
	public List<Book> findBookByAuthor(String author);
}
