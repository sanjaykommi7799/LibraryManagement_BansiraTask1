package com.BansiraTask.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BansiraTask.LibraryManagementSystem.Entity.Book;
import com.BansiraTask.LibraryManagementSystem.Service.LibraryService;
import com.BansiraTask.LibraryManagementSystem.exception.NotFoundException;

@RestController
@RequestMapping("/API/Library")
public class LibraryController {
	
	@Autowired
    private LibraryService libraryService;

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        return libraryService.addBook(book) ?
                ResponseEntity.ok("Book added successfully") :
                ResponseEntity.badRequest().body("Book with this ISBN already exists");
    }

    @DeleteMapping("/books/{ISBN}")
    public ResponseEntity<String> removeBook(@PathVariable String ISBN) {
    	if(ISBN!=null)
    	{
    		libraryService.removeBook(ISBN);
    		return ResponseEntity.ok("Book removed successfully");
    	}
    	else
    	{
    	 throw new NotFoundException("Book not found :"+ISBN);
    	}
       
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findBookByTitle(@PathVariable String title) {
        return libraryService.findBookByTitle(title);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> findBookByAuthor(@PathVariable String author) {
        return libraryService.findBookByAuthor(author);
    }

    @GetMapping("/books")
    public List<Book> listAllBooks() {
        return libraryService.listAllBooks();
    }

    @GetMapping("/books/available")
    public List<Book> listAvailableBooks() {
        return libraryService.listAvailableBooks();
    }

}
