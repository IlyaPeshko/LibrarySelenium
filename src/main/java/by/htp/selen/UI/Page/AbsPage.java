package by.htp.selen.UI.Page;

import org.openqa.selenium.WebDriver;

/**
 * Created by user on 04.04.17.
 */
public class AbsPage {

    protected WebDriver driver;

    public AbsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
