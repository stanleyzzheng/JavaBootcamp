package Runner;

import Controller.BookDaoImpl;
import Doainterface.BookDao;
import model.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessBook {
    private static BookDao bookDao = new BookDaoImpl();

    public static void main(String[] args) {
        System.out.println("---Inserting book records---");
        ArrayList<Book> bookList = new ArrayList<>();
//        Book b1 = new Book();
//        b1.setIsbn(120);
//        b1.setBookName("Java Book");

//        bookList.add(b1);
//        Book b2 = new Book();
//        b2.setIsbn(300);
//        b2.setBookName("Python Book");
//        bookList.add(b2);
//
//        Book b3 = new Book();
//        b3.setIsbn(365);
//        b3.setBookName("JavaScript Book");
//
//        Book b4 = new Book();
//        b4.setIsbn(256);
//        b4.setBookName("SQL Book");
//        bookList.add(b3);
//        bookList.add(b4);
//
//        bookDao.saveBook(bookList);
        System.out.println("====Display list of all books====");
        try {
            for (Book cc: bookDao.getAllBooks()){
                int ISBN = cc.getIsbn();
                String bookName = cc.getBookName();
                System.out.println("========");
                System.out.println("ISBN Number: " + ISBN + " and book name: " + bookName);
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        System.out.println("-------------Book information is updating------------");
        Book bookupdate = new Book();
        bookupdate.setIsbn(3);
        bookupdate.setBookName("Algorithms Book");
        boolean result = bookDao.updateBook(bookupdate,3);
        System.out.println(result);
        boolean a = bookDao.deleteBook(4);
        if(a==true){
            System.out.println("Record is deleted");
        }else{
            System.out.println("Record is not deleted");
        }

    }

}
