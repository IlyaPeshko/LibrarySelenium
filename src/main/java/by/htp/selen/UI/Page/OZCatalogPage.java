package by.htp.selen.UI.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.04.17.
 */
public class OZCatalogPage extends AbsPage {
    private static final By pagination = By.xpath(".//ul[@class='g-pagination__list']/child::*[last()]");
    private int quantity;

    public OZCatalogPage(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return super.getDriver();
    }

    public void open (String url){
        driver.get(url);
    }

    public List <String> fetchURLPages () throws InterruptedException {
        List <String> pageURL = new ArrayList<String>();
        String url;
        while (verifyExist()) {
            WebElement xPathBook = null;
            try {
                xPathBook = driver.findElement(By.xpath(".//*[@id='goods-table']/li[" + quantity + "]/div/div/div/a"));
                url = xPathBook.getAttribute("href");
                pageURL.add(url);
            }catch (NoSuchElementException e) {
                System.out.println("NoSuchElementException: " + quantity++ );
            }
        }
        return pageURL;
    }

    private boolean verifyExist () throws InterruptedException {
        boolean result = false;
        WebElement xPathBook = driver.findElement(By.xpath(".//*[@id='goods-table']/li[" + quantityBooksOnPage() + "]"));

            if (xPathBook.isEnabled()) {
                result = true;
            }
            if (xPathBook.getAttribute("style").equals("display: none;")) {
                return false;
            }

        return result;
    }

    public int pagination (){
        int page = 0;
        try {
            page = Integer.parseInt(driver.findElement(pagination).getAttribute("data-value"));

        }catch (NoSuchElementException e){
            System.out.println("Page " + page++ + " isn't exist, or not connected" );
        }
        return page;
    }

    private int quantityBooksOnPage (){
        quantity++;
        System.out.println("added " + quantity + " URL");
        return quantity;
    }
}
