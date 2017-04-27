package by.htp.selen.UI.Page;

import by.htp.selen.BO.Book;
import by.htp.selen.Utility.ParseToNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.04.17.
 */
public class OZProfilePage extends AbsPage {

    private final static By titleTarget = By.cssSelector(".b-product-title__heading>h1");
    private final static By authorTarget = By.cssSelector(".b-description__picture-name");
    private final static By priceTarget = By.cssSelector(".b-product-control__text.b-product-control__text_main");
    private final static By idOZbyTarget = By.cssSelector(".b-product-title__art");
    private final static By descriptionTarget = By.cssSelector("#truncatedBlock>p");
    private final static By imageURLTarget = By.xpath(".//div[@class='b-product-photo__picture-self']/figure/a/img");
    private final static By yearTarget = By.xpath(".//*[@itemprop='datePublished']/parent::td");

    //protected WebDriver driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);
    protected WebDriver driver;
    private Book book;

    public OZProfilePage(WebDriver driver) {
        super(driver);
    }

    public List <Book> booksByCatalog (List <String> URLList) throws InterruptedException {

        List <Book> books = new ArrayList<Book>();
        System.out.println("URLList.size"+URLList.size());

        for (int i=0; i<URLList.size(); i++){
            driver.get(URLList.get(i));
            book = new Book();
            try {
                book.setTitle(driver.findElement(titleTarget).getText());
                book.setAuthor(driver.findElement(authorTarget).getText());

                book.setPrice(ParseToNumber.parseAlltoDouble(driver.findElement(priceTarget).getText()));
                book.setIdOZby(ParseToNumber.parseAlltoInt(driver.findElement(idOZbyTarget).getText()));

                book.setDescription(driver.findElement(descriptionTarget).getText());
                book.setImageURL(driver.findElement(imageURLTarget).getAttribute("src"));
                book.setYear(Integer.parseInt(driver.findElement(yearTarget).getText() ));

                book.setBookURL(driver.getCurrentUrl());
            }catch (NoSuchElementException e){
                System.out.println("NoSuchElementException "  + URLList.get(i));
            }
            System.out.println(i + " " + book);
            books.add(book);
        }
        return books;
    }
}
