package Frugal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\Driver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Go to makemytrip.com
		driver.get("https://www.makemytrip.com/railways/");
		Thread.sleep(2000);

		// Print the URL and Title
		String url = driver.getCurrentUrl();
		System.out.println("URL: "+url);
		System.out.println("Title of page: " + driver.getTitle());
		
		// From City
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"From\"]")).sendKeys("DELHI");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/li[@data-suggestion-index=\"0\"]")).click();
		
		// To City
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("LUCKNOW");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*/li[@data-suggestion-index=\"0\"]")).click();
		
		// Date
		driver.findElement(By.xpath("//input[@id='travelDate']")).click();
        Thread.sleep(2000);
		while (true) {
            List<WebElement> dateElements = driver.findElements(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'May 20 2024')]"));
            if (dateElements.size() > 0) {
                dateElements.get(0).click();
                break;
            } else {
                driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
                Thread.sleep(1000);
            }
        }
		Thread.sleep(2000);

		// Class
		driver.findElement(By.xpath("//span[@class='appendBottom5 downArrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-cy=\"3A\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-cy=\"submit\"]")).click();
		Thread.sleep(7000);

		driver.quit();
	}

}