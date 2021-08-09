import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BBCWeather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bbc.com/weather");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ls-c-search__input-label")).sendKeys("Chennai",Keys.DOWN.ENTER);
		driver.findElement(By.xpath("//span[text()='23']")).click();
		String pressureVal = driver.findElement(By.xpath("//span[text()='23']/ancestor::button/div[2]/following::dd[2]")).getText();
		System.out.println(pressureVal);
	}

}
