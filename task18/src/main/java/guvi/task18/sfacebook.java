package guvi.task18;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sfacebook {

 public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
  WebDriver d=new ChromeDriver();
  d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  d.get("http://www.facebook.com/");
  d.manage().window().maximize();
    // Verify that the website has been redirected to the Facebook homepage
        if (d.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("Successfully navigated to the Facebook homepage.");
        } else {
            System.out.println("Failed to navigate to the Facebook homepage.");
            d.quit();
            return;
        }
        // Click on the "Create New Account" button
        d.findElement(By.linkText("Create new account")).click();
        d.findElement(By.name("firstname")).sendKeys("Test");
        d.findElement(By.name("lastname")).sendKeys("User");
        d.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
        d.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@test.com");
        d.findElement(By.name("reg_passwd__")).sendKeys("passsssss");
        
        
        //selection
        Select date=new Select(d.findElement(By.id("day")));
        date.selectByVisibleText("11");
        Select monthSelect = new Select(d.findElement(By.name("birthday_month")));
        monthSelect.selectByVisibleText("May");
        Select yearSelect = new Select(d.findElement(By.name("birthday_year")));
        yearSelect.selectByVisibleText("1985");
        // Select gender as "Male"
        d.findElement(By.cssSelector("input[name='sex'][value='1']")).click();

        // Click on the "Sign Up" button
        d.findElement(By.name("websubmit")).click();

        // Verify that the user is successfully registered and redirected to the Facebook homepage
        if (d.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("Successfully registered on Facebook and redirected to the homepage.");
        } else {
            System.out.println("Registration failed or redirection to the homepage unsuccessful.");
        }

        // Close the browser
        d.quit();
    }


}
