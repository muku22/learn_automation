
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testdemo extends ProjectSetup {

    public static void main(String[] args) throws InterruptedException {
      ProjectSetup p = new ProjectSetup();
        driver = p.openBrowser();

        //print no.of links present in page
 /*       System.out.println(driver.findElements(By.xpath("//body/div[2]/div/ul/li")).size());
        //alternate way to print no.of links present in page
        System.out.println(driver.findElements(By.tagName("li")).size());
*/
        //to open links of same page in different tab
Thread.sleep(3000);



        List<WebElement> pageLinks = driver.findElements(By.tagName("a"));

        for(int i=0;i<pageLinks.size();i++)
            System.out.println("link is "+pageLinks.get(i).getText());

        for(int  i=0;i<pageLinks.size();i++)
        {
            //System.out.println(i);
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            pageLinks.get(i).sendKeys(clickOnLink);
           // pageLinks.get(i).click();


        }
        driver.close();


    }
}