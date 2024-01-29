package Controller;

import Doainterface.BookDao;
import Doainterface.ConnectionDAO;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends ConnectionDAO implements BookDao {
    public void saveBook(List<Book> BookList) {
        try {
            Connection con = ConnectionDAO.getConnection();
            for (Book b : BookList) {
                String sqlQuery = "INSERT INTO books (isbn, bookName)" + "VALUES(?,?)";
                PreparedStatement prepstmt = con.prepareStatement(sqlQuery);
                prepstmt.setInt(1, b.getIsbn());
                prepstmt.setString(2, b.getBookName());
                int affectedRows = prepstmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected !!");

            }
        } catch (ClassNotFoundException e) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            disconnect();
        }

    }

    @Override
    public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
        try{
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            List bookList = new ArrayList();
            while (rs.next()){
                Book b = new Book();
                b.setIsbn(rs.getInt("isbn"));
                b.setBookName(rs.getString("bookName"));
                bookList.add(b);
            }
            return bookList;
        }catch(SQLException e){
            e.printStackTrace();

        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } finally{
            disconnect();
        }
        return null;
    }

    @Override
    public boolean deleteBook(int id) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i==1)return true;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            disconnect();
        }
        return false;
    }

    @Override
    public boolean updateBook(Book book, int id) {
        try{
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET isbn=?, bookName=? WHERE id=?");
            ps.setInt(1, book.getIsbn());
            ps.setString(2, book.getBookName());
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if(i==1) return  true;

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            disconnect();
        }
        return  false;
    }
}
