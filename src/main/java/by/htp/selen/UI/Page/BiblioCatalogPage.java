package by.htp.selen.UI.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.04.17.
 */
public class BiblioCatalogPage extends AbsPage{

    private static final By bookElementTarget = By.xpath(".//a[@class='quickview-button']");
    private static final By paginationTarget = By.xpath("//div [@ class='pages']/ol/child::*");
    private static final String URLPage = "http://biblio.by/knigi/komp-jutery-internet.html?___SID=U&limit=96&mode=grid&p=";
    private static final String elementAttribute = "href";

    public BiblioCatalogPage(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return super.getDriver();
    }

    public void open (String url){
        driver.get(url);
    }

    public List <String> fetchURLPages () throws InterruptedException, SQLException {
        List <String> pageURLList = new ArrayList<String>();
        List <WebElement> list = driver.findElements(bookElementTarget);

        for (WebElement o : list) {
            pageURLList.add(o.getAttribute(elementAttribute));
        }

        return pageURLList;
    }

    public int pagination () {
        driver.get(URLPage);
        int result = driver.findElements(paginationTarget).size();
        return result/2;
    }


}
