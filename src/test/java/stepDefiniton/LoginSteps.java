package stepDefiniton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	public static WebDriver driver;
	String currentDir = System.getProperty("user.dir");

	@When("^User switch on \"([^\"]*)\"$")
	public void user_switch_on(String browser) throws Throwable {
		Driver.initiateDriver(browser);
	}

	@When("^User goes to \"([^\"]*)\"$")
	public void user_goes_to(String link) throws Throwable {
		if (link.equals("flipkart"))
			Driver.getDriver().get("https://www.flipkart.com");
		else
			throw new Exception("link is not correct");
	}

	@When("^User bypass the LogIn Page$")
	public void user_bypass_the_LogIn_Page() throws Throwable {
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("//button[@class='_2KpZ6l _2doB4z']")).click();
//		//driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']//parent::label//parent::div//input")).sendKeys("akshaygoyal@hotmail.com");
//		//driver.findElement(By.xpath("//span[text()='Enter Password']//parent::label//parent::div//input")).sendKeys("aks@TCS9893");
//		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).click();
//		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("akshaygoyal@hotmail.com");
//		driver.findElement(By.xpath("//span[text()='Login']//parent::button")).click();
	}

	@Then("^User search for \"([^\"]*)\"$")
	public void user_search_for(String arg1) throws Throwable {
		driver.findElement(By.xpath("//title[text()='" + arg1 + "')")).sendKeys("Samsung Galaxy S10");
	}

	@Then("^User click on criteria$")
	public void user_click_on(String arg1) throws Throwable {
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//div[text()='SAMSUNG']//parent::label//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
	}

	@Then("^User prints the list of phones$")
	public void user_prints_the_list_of_phones() throws Throwable {
		List<WebElement> Items = driver.findElements(By.cssSelector("div[class='_1AtVbE col-12-12']"));

		for (WebElement item : Items) {
			String productName = item.findElement(By.cssSelector("//a//img[@class='_396cs4 _3exPp9'")).getAttribute("alt");
			String displayPrice = item.findElement(By.cssSelector("//div[@class='_30jeq3 _1_WHN1']")).getText();
			String link = item.findElement(By.cssSelector("//a//img[@class='_396cs4 _3exPp9'")).getAttribute("src");
			System.out.println(productName + "|" + displayPrice + "|" + link);
			//HashMap (key, list[3])
		}
	}

}