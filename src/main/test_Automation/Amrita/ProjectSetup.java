//import com.sun.tools.javac.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import examples;
import java.sql.Driver;
import java.util.Properties;

public class ProjectSetup {
    static WebDriver driver;

    public WebDriver openBrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
       return(driver);

    }

    public static void main(String[] args) {
        ProjectSetup p =new ProjectSetup();
        driver=p.openBrowser();
       // driver.get("http://the-internet.herokuapp.com/");
        driver.close();




    }
}
