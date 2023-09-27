package d26_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> exits = driver.findElements(By.cssSelector(".container > div >div > div > button"));
        for (int i = 0; i < exits.size(); i++) {
            int alerts = exits.size();
            exits.get(i).click();
            if (exits.size() != alerts){
                System.out.println("Alert successfully deleted!");
            } else {
                System.out.println("Alert deletion failed!");
            }
        }
        driver.quit();

    }
}
