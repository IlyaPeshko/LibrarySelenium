package by.htp.selen.UI.Service;

import by.htp.selen.BO.Book;
import by.htp.selen.DAO.ImplBookDAO;
import by.htp.selen.UI.Page.OZCatalogPage;
import by.htp.selen.UI.Page.OZProfilePage;
import by.htp.selen.UI.WebDriver.Driver;
import by.htp.selen.UI.WebDriver.DriverTypes;
import by.htp.selen.Utility.ScreenShot;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by user on 06.04.17.
 */
public class OZbyServiceBook {

    protected WebDriver driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);
    private Book book;
    private OZCatalogPage catalogPage;
    private static String URLpage = "https://oz.by/books/topic1.html?page=";
    private ScreenShot screenShot;
    private List<String> URLList;

    public void fetchBook() throws InterruptedException {
        screenShot = new ScreenShot();
        catalogPage = new OZCatalogPage(driver);

        catalogPage.open(URLpage);
        int j = catalogPage.pagination() +1;
        System.out.println("j "+ j);

        for (int i = 1; i < j; i++){
            catalogPage.open(URLpage+i);
            System.out.println(URLpage+i);
            catalogPage = new OZCatalogPage(driver);
            URLList = catalogPage.fetchURLPages();

            System.out.println("size" + URLList.size() + " / page " + i);
            screenShot.shoot(driver, driver.getCurrentUrl());

            OZProfilePage profilePage = new OZProfilePage(driver);
            List <Book> books = profilePage.booksByCatalog(URLList);

            System.out.println("books from main: " + books.size());

            ImplBookDAO sql = new ImplBookDAO();
            for (Book b : books) {
                sql.addBook(b);
            }

            URLList.clear();
        }
        driver.quit();
    }
}
