package seminars;

/*У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
*/

import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;
import seminars.fourth.book.InMemoryBookRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookRepository repository = new InMemoryBookRepository();
        BookService bookService = new BookService(repository);

        Book book1 = bookService.findBookById("1");
        System.out.println("Найдена книга: " + book1.getTitle() + " by " + book1.getAuthor());

        List<Book> allBooks = bookService.findAllBooks();
        System.out.println("Все книги:");
        for (Book book : allBooks) {
            System.out.println("- " + book.getTitle() + " от " + book.getAuthor());
        }
    }
}