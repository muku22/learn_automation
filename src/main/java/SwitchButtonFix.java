import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SwitchButtonFix {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        //driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).click();

        String bt1=driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']")).getText();
        System.out.println(bt1);
        String bt=driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).getText();
        System.out.println(bt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        Thread.sleep(4000);

        WebElement add= driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(add));
        String bt2=driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).getText();
        System.out.println(bt2);

        add.click();

        driver.close();
    }
}
