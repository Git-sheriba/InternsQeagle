import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();

		String items = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String repItem = items.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(repItem);
		System.out.println("Total count: " + count);

		String jackets = driver.findElement(By.xpath("//input[@value='Jackets']/following::span")).getText();
		String repjackets = jackets.replaceAll("[^0-9]", "");
		int countjackets = Integer.parseInt(repjackets);
		System.out.println("Count of Jackets: " + countjackets);

		String rainJacket = driver.findElement(By.xpath("//input[@value='Rain Jacket']/following::span")).getText();
		String reprainJacket = rainJacket.replaceAll("[^0-9]", "");
		int countrainJacket = Integer.parseInt(reprainJacket);
		System.out.println("Count of Jackets: " + countrainJacket);

		int sum = countjackets + countrainJacket;
		if (sum == count)
			System.out.println("It matches witht the total count");
		else
			System.out.println("It does not matches witht the total count");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Jackets')]")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[contains(text(),'Duke')]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		
		List<WebElement> prodBrand = driver.findElements(By.tagName("h3"));
		
		
		for (int i = 0; i < prodBrand.size(); i++) {
			
			String brand = prodBrand.get(i).getText();
			System.out.println(brand);
			if(!brand.equals("Duke")) {
				System.out.println("This is not a Duke brand product");
			}
		}
		
	}
}
