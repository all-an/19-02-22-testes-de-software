import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class SwitchToActiveWindow {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        Thread.sleep(20000);


        Integer continua = 1;
        while(continua == 1){


            Thread.sleep(5000);
            WebElement autocomplete = driver.findElement(By.className("_13NKt copyable-text selectable-text"));
//            autocomplete.sendKeys("Te amo !");

//            WebElement newTabButton = driver.findElement(By.className("_4sWnG"));
//            newTabButton.click();

        }

        WebElement autocomplete = driver.findElement(By.className("_13NKt copyable-text selectable-text"));
        autocomplete.sendKeys("Teste !");



        Thread.sleep(5000);

        String originalHandle = driver.getWindowHandle();

        for(String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        Thread.sleep(3000);

        driver.switchTo().window(originalHandle);

        sc.nextLine();
        driver.quit();
    }
}
