package d25_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak
        //Maksimizirati prozor
        //Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        //Prijavite se na sistem
        //Username: Admin
        //Password: admin123
        //Cekanje od 5s
        //U input za pretragu iz navigacije unesite tekst Me
        //Kliknite na prvi rezultat pretrage (to ce biti Time)
        //Cekanje od 1s
        //Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
        //Klinkite na logout
        //Cekanje od 5s
        //Zatvorite pretrazivac

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("input@placeholder='Search'")).sendKeys("Me");
        driver.findElement(By.cssSelector("nav ul > li:nth-child(1) > a")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("header img")).click();

        driver.findElement(By.linkText("Logout")).click();

        Thread.sleep(5000);
        driver.quit();




    }
}
