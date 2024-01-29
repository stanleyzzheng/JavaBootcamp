package Doainterface;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getAllBooks() throws ClassNotFoundException, SQLException;

    void saveBook(List<Book> BookList);

    boolean deleteBook(int id);

    boolean updateBook(Book book, int id);
}
