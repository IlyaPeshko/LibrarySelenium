package by.htp.selen;

import by.htp.selen.BO.Book;
import by.htp.selen.UI.Page.OZCatalogPage;
import by.htp.selen.UI.Service.BiblioService;
import by.htp.selen.UI.Service.OZbyServiceBook;
import by.htp.selen.UI.WebDriver.Driver;
import by.htp.selen.UI.WebDriver.DriverTypes;

import org.openqa.selenium.WebDriver;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by user on 04.04.17.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, SQLException {

        System.out.println("Добро пожалова");
        System.out.println("выберите ресур для сбора книг, для этого введите соответсвующее число:");
        System.out.println("    1 - OZ.by");
        System.out.println("    2 - Biblio.by");

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        switch (num){
            case 1:
                OZbyServiceBook oZbyServiceBook = new OZbyServiceBook();
                oZbyServiceBook.fetchBook();
                break;
            case 2:
                BiblioService biblioService = new BiblioService();
                biblioService.fetchBooksCatalog();
                break;
            default:
                System.out.println("Вы ввели неверное значение");
        }
    }
}
