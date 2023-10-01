package d29_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
//        Napisati program koji testira infinity scroll.
//	Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//	Selektujte delay od 2000ms, koristeci Select klasu.
//	Skrol do Show more dugmeta koje se nalazi na dnu stranice
//	Sacekajte da dugme bude klikljivo
//	Klik na Show more dugme
//	Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//	Sacekajte da dugme vise ne bude klikljivo


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        Select delay = new Select(driver.findElement(By.id("delay-select")));
        delay.selectByValue("2000");
        new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button")));
        driver.findElement(By.id("infinite-scroll-button")).click();


        List<WebElement> items = driver.findElements(By.cssSelector("div.item"));
        int counter = 0;
        for (int i = 0; i < items.size(); i++) {
            counter = counter + 1;
        }
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.item"), counter));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("infinite-scroll-button"), "Show more"));

        driver.quit();

    }
}
