import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.Scanner;

public class Datepicker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/datepicker");

        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("03/03/2020");
        dateField.sendKeys(Keys.RETURN);

        sc.nextLine();

        driver.quit();
    }
}