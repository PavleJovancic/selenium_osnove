package d29_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Task7 {
    public static void main(String[] args) throws InterruptedException {
//        Napisati program koji:
//       Ucitava stranicu https://tus.io/demo.html
//       Hvata sve linkove sa stranice
//       Skrola do svakog h3 elementa
//        Od svakog h3 elementa cita text
//

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tus.io/demo.html");


        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<WebElement> headings = driver.findElements(By.tagName("h3"));

        for (int i = 0; i < headings.size(); i++) {
            new Actions(driver).scrollToElement(headings.get(i));
            System.out.println(headings.get(i).getText());

        }
        driver.quit();
    }
}
