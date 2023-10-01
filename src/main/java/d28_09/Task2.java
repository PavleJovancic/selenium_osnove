package d28_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        //Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
        //Klik na svako dugme od PRIMARY do DARK
        //Sacekati da se toasts u desnom gornjem uglu pojavi
        //Pauza izmedju klikova 1s
        //Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> buttons = driver.findElements(By.cssSelector("#section-basic-example  div.container button"));


        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'toast') and contains(@class, 'fade')  and contains(@class, 'mx-auto')]")));
            Thread.sleep(1000);
        }

        driver.quit();
    }
}
