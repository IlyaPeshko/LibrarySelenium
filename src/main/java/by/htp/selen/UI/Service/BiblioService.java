package by.htp.selen.UI.Service;

import by.htp.selen.BO.Book;
import by.htp.selen.DAO.ImplBookDAO;
import by.htp.selen.UI.Page.BiblioCatalogPage;
import by.htp.selen.UI.Page.BiblioProfilePage;
import by.htp.selen.UI.WebDriver.Driver;
import by.htp.selen.UI.WebDriver.DriverTypes;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.04.17.
 */
public class BiblioService {

    private static final String URLPage = "http://biblio.by/knigi/komp-jutery-internet.html?___SID=U&limit=96&mode=grid&p=";
    protected WebDriver driver = Driver.getWebDriverInstance("chrome", DriverTypes.GC);

    BiblioCatalogPage biblioCatalogPage;
    BiblioProfilePage biblioProfilePage;
    ImplBookDAO implBookDAO;

    private List<String> fetchURLList () throws InterruptedException, SQLException {
        biblioCatalogPage = new BiblioCatalogPage(driver);
        List <String> URLs = new ArrayList();

        int pagination = biblioCatalogPage.pagination();
        int i = 1;

        while (i <= pagination) {
            biblioCatalogPage.open(URLPage+i);

            List <String> list = biblioCatalogPage.fetchURLPages();
            URLs.addAll(list);
            i++;
        }

        return URLs;
    }

    public List <Book> fetchBooksCatalog () throws InterruptedException, SQLException {
        List <String> URLs = fetchURLList();

        biblioProfilePage = new BiblioProfilePage(driver);
        List <Book> booksCatalog = biblioProfilePage.booksByCatalog(URLs);

        implBookDAO = new ImplBookDAO();
        for (Book book : booksCatalog) {
            implBookDAO.addBook(book);
        }

        return booksCatalog;
    }

}
