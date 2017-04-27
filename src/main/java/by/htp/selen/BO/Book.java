package by.htp.selen.BO;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by user on 04.04.17.
 */
public class Book {

    private String title;
    private String author;
    private int idOZby;

    private int year;
    private double price;

    private String imageURL;
    private String bookURL;
    private String description;
    private Date date;


    public Book (){}

    public Book(String title, String author, int idOZby, int year, double price, String imageURL, String bookURL, String description, Date date) {
        this.title = title;
        this.author = author;
        this.idOZby = idOZby;
        this.year = year;
        this.price = price;
        this.imageURL = imageURL;
        this.bookURL = bookURL;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BOOK{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", idOZby='" + idOZby + '\'' +
                ", price='" + price + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", year='" + year + '\'' +
                ", bookURL='" + bookURL + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdOZby() {
        return idOZby;
    }

    public void setIdOZby(int idOZby) {
        this.idOZby = idOZby;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getBookURL() {
        return bookURL;
    }

    public void setBookURL(String bookURL) {
        this.bookURL = bookURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
