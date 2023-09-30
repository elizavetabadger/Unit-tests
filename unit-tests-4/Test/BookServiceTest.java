/*У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
*/

import org.junit.jupiter.api.Test;

import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;
import seminars.fourth.book.InMemoryBookRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    @Test
    public void testFindBookById() {
        BookRepository mockRepository = mock(BookRepository.class);

        when(mockRepository.findById("123")).thenReturn(new Book("123", "Test Book", "Test Author"));

        BookService bookService = new BookService(mockRepository);

        Book result = bookService.findBookById("123");

        assertEquals("Test Book", result.getTitle());
        assertEquals("Test Author", result.getAuthor());
    }

    @Test
    public void testFindAllBooks() {
        BookRepository mockRepository = mock(BookRepository.class);

        when(mockRepository.findAll()).thenReturn(List.of(new Book("123", "Test Book", "Test Author")));

        BookService bookService = new BookService(mockRepository);

        List<Book> result = bookService.findAllBooks();

        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
        assertEquals("Test Author", result.get(0).getAuthor());
    }
}