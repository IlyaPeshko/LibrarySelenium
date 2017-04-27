package by.htp.selen.DAO;

import by.htp.selen.BO.Book;

import java.sql.*;


/**
 * Created by user on 01.04.17.
 */
public class ImplBookDAO implements BookDAO{

    private static Date date = new Date(System.currentTimeMillis());
    private static final String jdbcDriver = "com.mysql.jdbc.Driver";
    @Override
    public void addBook(Book book) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        book.setDate(date);

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(SQL_URL, SQL_USERNAME, SQL_PASSWORD);

            String query = "INSERT INTO `book_library`.`book_extend` (`title`, `author`, `year`, `price`, " +
                    "`imageURL`, `bookURL`, `description` , `idOZby`, `addDate`, `source` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";


            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getYear());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setString(5, book.getImageURL());
            preparedStatement.setString(6, book.getBookURL());
            preparedStatement.setString(7, book.getDescription());
            preparedStatement.setInt(8, book.getIdOZby());
            preparedStatement.setDate(9,book.getDate());
            preparedStatement.setString(10, "biblio");


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                    if (connection != null){
                        connection.close();}
                }catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("error sql connection!");
                }
            }
        }
    }

    @Override
    public boolean fetchByTitle(String title) {
        return false;
    }
}
