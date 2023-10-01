package d29_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
//        Napisati program koji:
//        Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//        Ceka da broj toasts-a bude 4
//        Ispisuje poruku, toasts su prikazani
//        Ceka da broj toasts-a bude 0
//        Ispisuje poruku, toasts su se izgubili

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.findElement(By.id("basic-primary-trigger")).click();
        driver.findElement(By.id("basic-secondary-trigger")).click();
        driver.findElement(By.id("basic-success-trigger")).click();
        driver.findElement(By.id("basic-danger-trigger")).click();


        WebElement locator = driver.findElement((By.xpath("//div[contains(@class, 'toast') and contains(@class, 'fade')  and contains(@class, 'mx-auto')]")));
        wait.until(ExpectedConditions.numberOfElementsToBe((By) locator, 4));
        System.out.println("Toasts are shown");
        wait.until(ExpectedConditions.numberOfElementsToBe((By) locator, 4));
        System.out.println("Toasts are gone");

        driver.quit();

    }
}
