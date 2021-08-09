import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BBasket {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Go to https://www.bigbasket.com/
		driver.get("https://www.bigbasket.com/");
		
		//mouse over on  Shop by Category 
		WebElement shopCategory=driver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']");
		Actions builder=new Actions(driver);
		builder.moveToElement(shopCategory).perform();
		
		//Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS
		driver.findElementByXPath("(//a[contains(text(),'Foodgrains, Oil & Masala')])[2]").click();
		
		//Click on Boiled & Steam Rice
		driver.findElementByXPath("(//span[contains(text(),'Rice & Rice Products')])[1]").click();
		driver.findElementByXPath("(//span[contains(text(),'Boiled & Steam Rice')])[1]").click();
		
		//Choose the Brand as bb Royal
		driver.findElementByXPath("(//span[contains(text(),'BB Royal')])[1]").click();
		
		Thread.sleep(5000);
		
		//Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
		driver.findElementByXPath("//a[contains(text(),'Rice - Boiled, Tamil Ponni')]").click();
		
		//print the price of Rice
		String printPrice=driver.findElementByXPath("(//td[@class='IyLvo'])").getText();
		System.out.println("The Price of Ponni Boiled Rice -Super Premium 5kg bag is  "+printPrice);
		
		//Click Add button
		driver.findElementByXPath("//span[contains(text(),'ADD TO BASKET')]").click();
		
		//Verify the success message displayed 
		
		
		// Type Dal in Search field and enter
		driver.findElementById("productSearch").sendKeys("Dal",Keys.ENTER);
		
		//Go to Toor/Arhar Dal and select 2kg & set Qty 2 
		driver.findElementByXPath("//a[contains(text(),'Organic - Toor Dal/Togari Bele')]").click();
		driver.findElementByXPath("//span[contains(text(),'ADD TO BASKET')]").click();
		
		//Print the price of Dal
		String printPriceOfDal=driver.findElementByXPath("(//td[@class='IyLvo'])[1]").getText();
		System.out.println("The Price of Dal of two quantity of two kg is  "+printPriceOfDal);
		
		//Click Add button
		WebElement findElementByXPath = driver.findElementByXPath("//div[@class='_1aJzw']");
		// Mouse hover on My Basket 
		WebElement toBasket=driver.findElementByXPath("//span[contains(text(),'My Basket')]");
		Actions builder2=new Actions(driver);
		builder2.moveToElement(toBasket).perform();
		
		//Validate the Sub Total displayed for the selected items
		String subTotal=driver.findElementByXPath("//div[@class='Mbz4m']/span[2]").getText();
		System.out.println("The Sub Total Of Products in Basket is  "+subTotal);
		
		//Reduce the Quantity of Dal as 1 
		driver.findElementByXPath("(//div[@class='_2bvd7'])[2]").click();
		
		//Validate the Sub Total for the current items
		String currentSubTotal=driver.findElementByXPath("//div[@class='Mbz4m']/span[2]").getText();
		System.out.println("The Sub Total Of Current Products in Basket is  "+currentSubTotal);
		
		//close Browser
		driver.close();
	}

}
