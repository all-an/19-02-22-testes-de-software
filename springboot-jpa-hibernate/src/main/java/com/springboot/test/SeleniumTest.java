package com.springboot.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class SeleniumTest {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Set the property for webdriver.chrome.driver to be the location to your local              download of chromedriver
            System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

            // Create new instance of ChromeDriver
            WebDriver driver = new ChromeDriver();

            // And now use this to visit Google
            driver.get("http://www.google.com");

            // Find the text input element by its name
            WebElement element = driver.findElement(By.name("q"));

            // Enter something to search for
            element.sendKeys("Queijo!");

            // Now submit the form
            element.submit();

            scanner.nextLine();

            //Close the browser
            driver.quit();
        }
    }
