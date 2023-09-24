package d22_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        //Napisati program koji:
        //ima niz od 5 stringova. Svaki element u nizu je url stranice:
        //https://www.google.com/
        //https://www.facebook.com/
        //https://www.youtube.com/
        //https://www.ebay.com/
        //https://www.katalon.com/
        //zatim koristeci for petlju otvara svaku stranicu iz niza u pretrazivacu prateci sledeca pravila:
        //za svaku stranicu se kreira nova infrastuktura
        //ucitava stranica
        //pravi pauza od 1s
        //ponistava testna stuktura

        ArrayList<String> url = new ArrayList<>();
        url.add("https://www.google.com/");
        url.add("https://www.facebook.com/");
        url.add("https://www.youtube.com/");
        url.add("https://www.ebay.com/");
        url.add("https://www.katalon.com/");


        for (int i = 0; i < url.size(); i++) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(url.get(i));
            Thread.sleep(1000);
            driver.quit();
        }
    }

}
