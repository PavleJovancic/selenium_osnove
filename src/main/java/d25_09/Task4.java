package d25_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://artplayer.org/");

        Thread.sleep(4000);

        driver.findElement(By.cssSelector("div.art-control-playAndPause")).click();
        driver.findElement(By.cssSelector("div.art-control-volume")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div.art-control-screenshot")).click();
        driver.findElement(By.cssSelector("div.art-control-pip")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div.art-control-pip")).click();
        driver.findElement(By.cssSelector("div.art-control-fullscreenWeb")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div.art-control-fullscreenWeb")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}
