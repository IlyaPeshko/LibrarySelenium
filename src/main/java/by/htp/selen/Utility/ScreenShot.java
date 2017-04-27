package by.htp.selen.Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.ScreenshotException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by user on 26.03.17.
 */
public class ScreenShot {
    private Date timeShot = new Date();
    private static final By target = By.xpath(".//*[@id='top-page']/div[3]/div/div[2]/div/div");

    public void shoot(WebDriver driver, String testName){
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/user/Desktop", testName + " " + timeShot + ".png"));
        } catch (ScreenshotException e) {
            throw new ScreenshotException("ScreenshotException " + e);
        } catch (IOException e){
            System.out.println("second catch (IOException e) " + e);
        }
    }



    public void shootByElement (WebDriver driver, WebElement element) throws Exception {
        // Делаем скриншот страницы
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screen, new File("/Users/user/Desktop/"," " + timeShot + ".png"));

        // Создаем экземпляр BufferedImage для работы с изображением
        BufferedImage img = ImageIO.read(screen);
        // Получаем размеры элемента
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // Создаем прямоуголник (Rectangle) с размерами элемента
        Rectangle rect = new Rectangle(width, height);
        // Получаем координаты элемента
        org.openqa.selenium.Point p = element.getLocation();
        // Вырезаем изображенеи элемента из общего изображения
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height+200);
        // Перезаписываем File screen
        ImageIO.write(dest, "png", screen);
        // Возвращаем File c изображением элемента
        FileUtils.copyFile(screen, new File("/Users/user/Desktop/",  "try" + timeShot + ".png"));
    }
}
