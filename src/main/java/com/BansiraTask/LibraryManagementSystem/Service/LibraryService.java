package com.BansiraTask.LibraryManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.BansiraTask.LibraryManagementSystem.DAO.BookRepository;
import com.BansiraTask.LibraryManagementSystem.DAO.DepartmentRepository;
import com.BansiraTask.LibraryManagementSystem.Entity.Book;

@Service
public class LibraryService {
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
    private DepartmentRepository departmentRepository;

    public boolean addBook(Book book) {
        if (((CrudRepository<Book,String>) bookRepository).existsById(book.getISBN())) {
            return false; // Duplicate ISBN
        }
        return ((CrudRepository<Book,String>) bookRepository).save(book) != null;
    }

    public boolean removeBook(String ISBN) {
        if (((CrudRepository<Book,String>) bookRepository).existsById(ISBN)) {
            ((CrudRepository<Book,String>) bookRepository).deleteById(ISBN);
            return true;
        }
        return false;
    }

    public List<Book> findBookByTitle(String title) {
      List<Book> books=((BookRepository) bookRepository).findBookByTitle(title);
      return books;
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthor(author);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> listAvailableBooks() {
        return bookRepository.findAll().stream()
                .filter(Book::isAvailable)
                .toList();
    }
}
