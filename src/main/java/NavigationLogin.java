import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationLogin {
    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vk sinha\\Downloads\\chromedriver_win32 03rd apr,22//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://scoolio-dev.track-progress.com/");

        driver.findElement(By.name("email")).sendKeys("guinnessworld@yopmail.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("button")).click();
        driver.findElement(By.className("launch_button")).click();

    }

}

