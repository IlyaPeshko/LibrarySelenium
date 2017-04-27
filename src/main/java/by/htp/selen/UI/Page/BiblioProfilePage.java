package by.htp.selen.UI.Page;

import by.htp.selen.BO.Book;
import by.htp.selen.UI.WebDriver.Driver;
import by.htp.selen.UI.WebDriver.DriverTypes;
import by.htp.selen.Utility.ParseToNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.04.17.
 */
public class BiblioProfilePage extends AbsPage{

    protected WebDriver driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);

    private final static By titleTarget = By.cssSelector(".product-name>h1");
    private final static By authorTarget = By.cssSelector(".aditional-attribute>a");
    private final static By priceTarget = By.xpath(".//*[@class='price']");

    private final static By descriptionTarget = By.xpath(".//*[@class='std']");
    private final static By yearTarget = By.xpath(".//*[@class='aditional-attribute'][3]");

    private final static By imageURLTarget = By.xpath(".//*[@class='fancybox']/img");
    private final static By imageURLTarget2 = By.xpath(".//*[@id='ma-zoom1']");

    private final static String imageAttrebute = "src";
    private final static String imageAttrebute2 = "href";

    private List <Book> books;
    private Book book;


    public BiblioProfilePage(WebDriver driver) {
        super(driver);
    }

    public List<Book> booksByCatalog (List <String> URLList) throws InterruptedException {

        books = new ArrayList<Book>();
        int listSize = URLList.size();
        System.out.println("URLList.size"+ listSize);

        for (int i=0; i<listSize; i++){
            driver.get(URLList.get(i));
            book = new Book();

            try {
                book.setTitle(driver.findElement(titleTarget).getText());
                book.setBookURL(URLList.get(i));
                book.setPrice(ParseToNumber.parseAlltoDouble(driver.findElement(priceTarget).getText()));
                book.setDescription(driver.findElement(descriptionTarget).getText());
                book.setYear(ParseToNumber.parseAlltoInt(driver.findElement(yearTarget).getText()));


                try {book.setImageURL(driver.findElement(imageURLTarget).getAttribute(imageAttrebute));
                } catch (NoSuchElementException e){book.setImageURL(driver.findElement(imageURLTarget2).getAttribute(imageAttrebute2));}

                try { book.setAuthor(driver.findElement(authorTarget).getText());
                } catch (NoSuchElementException e) {book.setAuthor(" ");}


            }catch (NoSuchElementException e){
                System.out.println("NoSuchElementException "  + URLList.get(i));
            }
            System.out.println(i + " " + book);
            books.add(book);
        }
        return books;
    }
}
