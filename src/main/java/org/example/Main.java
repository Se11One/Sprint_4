package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    public static void main(String[] args) {
        //WebDriver driver;

        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDriver\\bin\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        /*WebDriverManager.firefoxDriver().setup();
        driver = new FirefoxDriver();*/

        driver.get("https://www.selenium.dev/");
    }
}