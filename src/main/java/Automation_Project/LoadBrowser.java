package Automation_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadBrowser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://reseller.bose.com");
        System.out.println("Test has been passed ");
        driver.close();
    }
}
