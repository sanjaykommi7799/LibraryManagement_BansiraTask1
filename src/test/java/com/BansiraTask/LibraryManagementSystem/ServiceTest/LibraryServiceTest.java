package com.BansiraTask.LibraryManagementSystem.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.BansiraTask.LibraryManagementSystem.DAO.BookRepository;
import com.BansiraTask.LibraryManagementSystem.DAO.DepartmentRepository;
import com.BansiraTask.LibraryManagementSystem.Entity.Book;
import com.BansiraTask.LibraryManagementSystem.Service.LibraryService;

@SpringBootTest
public class LibraryServiceTest {
	@InjectMocks
	private LibraryService libraryService;
	@Mock
    private BookRepository bookRepository;
	@Mock
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        departmentRepository = Mockito.mock(DepartmentRepository.class);
        libraryService = new LibraryService();
     //   libraryService.setBookRepository(bookRepository);
      //  libraryService.setDepartmentRepository(departmentRepository);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBookSuccessfully() {
        Book book = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
        when(bookRepository.existsById(book.getISBN())).thenReturn(false);
        when(bookRepository.save(book)).thenReturn(book);

        assertTrue(libraryService.addBook(book));
        verify(bookRepository).save(book);
    }

    @Test
    void testAddBookDuplicateISBN() {
        Book book = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
        when(bookRepository.existsById(book.getISBN())).thenReturn(true);

        assertFalse(libraryService.addBook(book));
        verify(bookRepository, never()).save(book);
    }

    @Test
    void testRemoveBookSuccessfully() {
        String ISBN = "1234567890";
        when(bookRepository.existsById(ISBN)).thenReturn(true);

        assertTrue(libraryService.removeBook(ISBN));
        verify(bookRepository).deleteById(ISBN);
    }

    @Test
    void testRemoveBookNotFound() {
        String ISBN = "1234567890";
        when(bookRepository.existsById(ISBN)).thenReturn(false);

        assertFalse(libraryService.removeBook(ISBN));
        verify(bookRepository, never()).deleteById(ISBN);
    }

    @Test
    void testFindBookByTitle() {
        Book book = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(bookRepository.findBookByTitle("Java Programming")).thenReturn(books);

        List<Book> foundBooks = libraryService.findBookByTitle("Java Programming");
        assertEquals(1, foundBooks.size());
        assertEquals("Java Programming", foundBooks.get(0).getTitle());
    }

    @Test
    void testFindBookByAuthor() {
        Book book = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
        List<Book> books = new ArrayList<>();
        books.add(book);
        when(bookRepository.findBookByAuthor("John Doe")).thenReturn(books);

        List<Book> foundBooks = libraryService.findBookByAuthor("John Doe");
        assertEquals(1, foundBooks.size());
        assertEquals("John Doe", foundBooks.get(0).getAuthor());
    }

    @Test
    void testListAllBooks() {
        Book book1 = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
        Book book2 = new Book("0987654321", "Python Programming", "Jane Doe", "Technology", 2022, "Computer Science");
        List<Book> books = List.of(book1, book2);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> allBooks = libraryService.listAllBooks();
        assertEquals(2, allBooks.size());
    }

    @Test
    void testListAvailableBooks() {
        Book book1 = new Book("1234567890", "Java Programming", "John Doe", "Technology", 2023, "Computer Science");
        book1.setAvailable(true);
        Book book2 = new Book("0987654321", "Python Programming", "Jane Doe", "Technology", 2022, "Computer Science");
        book2.setAvailable(false);
        List<Book> books = List.of(book1, book2);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> availableBooks = libraryService.listAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("Java Programming", availableBooks.get(0).getTitle());
    }

}
