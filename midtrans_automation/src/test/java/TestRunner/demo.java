package TestRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class demo {
	public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","/Users/me20050937/git/UI-Test-Automation/midtrans_automation/Drivers/Chromedriver/Mac32/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.midtrans.com/");
    }

}
