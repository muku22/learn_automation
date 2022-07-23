import dev.failsafe.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class DragDownTest{
    public static void main(String[] args) throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        // before drag and drop
        System.out.println(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/header")).getText());


        WebElement source= driver.findElement(By.xpath("//*[@id='column-a']"));
        WebElement target=driver.findElement(By.xpath("//*[@id='column-b']"));

        System.out.println("source is "+source.getText());
        System.out.println("target is "+target.getText());

// using JS executor as site is built on Html5 not suitable for dragdown in chrome browser - https://github.com/SeleniumHQ/selenium/issues/6235


        String xto=Integer.toString(source.getLocation().x);
        String yto=Integer.toString(target.getLocation().y);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, target);
        Thread.sleep(1500);







        //Action dragAndDrop = a.clickAndHold(source).moveToElement(target).release(target).build();
        //a.dragAndDrop(driver.findElement(By.id("column-a")),driver.findElement(By.id("column-b"))).build().perform();

        //after drag and drop
        System.out.println(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/header")).getText());
        // System.out.println(driver.findElement(By.id("column-a")).getText());
        Thread.sleep(3000);
        //driver.close();
    }


}
