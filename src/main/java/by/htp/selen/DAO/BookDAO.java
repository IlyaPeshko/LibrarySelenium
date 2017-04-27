package by.htp.selen.DAO;

import by.htp.selen.BO.Book;

/**
 * Created by user on 04.04.17.
 */
public interface BookDAO {
    public static final String SQL_URL = "jdbc:mysql://localhost:" + "3306/book_library?&characterEncoding=utf-8&...";
    //public static final String SQL_URL = "jdbc:mysql://localhost:3306/book_library";
    public static final String SQL_USERNAME = "root";
    public static final String SQL_PASSWORD = "root";



    public void addBook(Book book);

    boolean fetchByTitle (String title);
}
