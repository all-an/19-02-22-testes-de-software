import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.Scanner;

public class Radiobuttons {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/radiobutton");

        Thread.sleep(5000);

        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();

        Thread.sleep(5000);

        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();

        Thread.sleep(5000);

        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
        radioButton3.click();

        sc.nextLine();

        driver.quit();
    }
}
