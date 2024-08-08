package com.BansiraTask.LibraryManagementSystem.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.BansiraTask.LibraryManagementSystem.Entity.Book;

@SpringBootTest
public class BookTest {

	    @Test
	    void testBookCreation() {
	        Book book = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
	        assertEquals("Java Programming", book.getTitle());
	        assertEquals("John Doe", book.getAuthor());
	        assertEquals("Technology", book.getGenre());
	        assertEquals(2023, book.getPublicationYear());
	        assertEquals("Computer Science", book.getDepartment());
	        assertTrue(book.isAvailable());
	    }

	    @Test
	    void testSetAvailable() {
	        Book book = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
	        book.setAvailable(false);
	        assertFalse(book.isAvailable());
	    }

}
