
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.Scanner;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.tagName("input"));
        autocomplete.sendKeys("Cheese");
        Thread.sleep(1000);

        WebElement autocompleteResult = driver.findElement(By.className("dismissButton"));
        autocompleteResult.click();

        sc.nextLine();

        driver.quit();
    }
}