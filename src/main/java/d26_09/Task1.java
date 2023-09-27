package d26_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        System.out.print("First Name: ");
        driver.findElement(By.id("firstName")).sendKeys(s.next());

        System.out.print("Last Name: ");
        driver.findElement(By.id("lastName")).sendKeys(s.next());

        System.out.print("Email: ");
        driver.findElement(By.id("userEmail")).sendKeys(s.next());

        System.out.print("Gender: ");
        String gender = s.next();
        if (gender.equals("male")){
            driver.findElement(By.xpath("//input[@value='Male']")).click();
        } else if (gender.equals("female") ) {
            driver.findElement(By.xpath("//input[@value='Female']")).click();
        } else {
            driver.findElement(By.xpath("//input[@value='Other']")).click();
        }

        System.out.print("Mobile: ");
         driver.findElement(By.id("userNumber")).sendKeys(s.next());


        System.out.print("Subjects: ");
        driver.findElement(By.cssSelector("#subjectsContainer > div > div")).sendKeys(s.next());

        System.out.print("Hobbies: ");
        String hobbies = s.next();
        if (hobbies.equals("sports")){
            driver.findElement(By.cssSelector("#hobbies-checkbox-1")).click();
        } else if (hobbies.equals("reading")) {
            driver.findElement(By.cssSelector("#hobbies-checkbox-2")).click();
        } else if (hobbies.equals("music")){
            driver.findElement(By.cssSelector("#hobbies-checkbox-3")).click();
        }

        System.out.print("Address:");
        driver.findElement(By.id("currentAddress")).sendKeys(s.next());

        System.out.print("State: ");

        Select state = new Select(driver.findElement(By.cssSelector("#state")));
        state.selectByVisibleText(s.next());

        System.out.print("City: ");
        Select city = new Select(driver.findElement(By.cssSelector("#city")));
        city.selectByVisibleText(s.next());

        driver.findElement(By.id("submit")).click();

        driver.quit();


    }
}
