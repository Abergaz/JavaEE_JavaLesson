package ee.servlet;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DIExample")
public class DependencyInjectionExample extends HttpServlet {
    @Inject
    BookService bookService;
    @Inject
    Subscriber subscriber;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book one = new Book("one");
        bookService.addBook(one);
        bookService.addBook(new Book("two"));
        bookService.addBook(new Book("free"));
        bookService.addBook(new Book("four"));
        System.out.println(subscriber.list.size());
        bookService.removeBook(one);
        System.out.println(subscriber.list.size());
    }
}

@Qualifier
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Add {
}

@Qualifier
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Remove {
}

class Book {
    String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BookService {
    @Inject
    @Add
    private Event<Book> addEvent;
    @Inject
    @Remove
    private Event<Book> removeEvent;

    public void addBook(Book book) {
        System.out.println(book.getName() + " book was added");
        addEvent.fire(book); /** при наступлении события fire наш полдписчик будет реагировать и вызывать свой метод add*/
    }

    public void removeBook(Book book) {
        System.out.println(book.getName() + " book was deleted");
        removeEvent.fire(book);
    }
}

@Singleton
        /** Один экземпляр бина на весь контекст */
class Subscriber {
    List<Book> list = new ArrayList<>();

    public void add(@Observes @Add Book book) {/** помечаем что наблюдаем за book*/
        list.add(book);
        System.out.println(book.getName() + " add as list");
    }

    public void delete(@Observes @Remove Book book) {
        list.remove(book);
        System.out.println(book.getName() + " delete from list");
    }
}