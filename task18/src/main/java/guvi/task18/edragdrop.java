package guvi.task18;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class edragdrop {

 public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
  WebDriver d=new ChromeDriver();
  d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  d.manage().window().maximize();

        // Navigate to the jQueryUI droppable website
        d.get("https://jqueryui.com/droppable/");
        d.manage().window().maximize();

        // Switch to the iframe containing the demo
        d.switchTo().frame(d.findElement(By.cssSelector(".demo-frame")));

        // Find the source element
        WebElement sourceElement = d.findElement(By.xpath("//div[@id='draggable']"));

        // Find the target element
        WebElement targetElement = d.findElement(By.xpath("//div[@id='droppable']"));

        // Perform the drag and drop operation
        Actions actions = new Actions(d);
        actions.dragAndDrop(sourceElement, targetElement).perform();
        
        // Verify the color property of the target element's CSS
        String targetColor = targetElement.getCssValue("rgba(70, 130, 180, 1");
        if (targetColor.equals("rgba(70, 130, 180, 1)")) {
            System.out.println("Drag and drop operation successful. Target element has changed color.");
        } else {
            System.out.println("Drag and drop operation failed. Target element color not changed.");
        }

        // Verify the text of the target element
        String targetText = targetElement.getText();
        if (targetText.equals("Dropped!")) {
            System.out.println("Text of the target element updated to 'Dropped!'");
        } else {
            System.out.println("Text of the target element not updated.");
        }

        // Close the browser
        d.quit();
    }
}