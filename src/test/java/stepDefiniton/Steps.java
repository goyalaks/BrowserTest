package stepDefiniton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
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
		Thread.sleep(4000);
		Driver.getDriver().findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}

	@Then("^User search for \"([^\"]*)\"$")
	public void user_search_for(String arg1) throws Throwable {
		Driver.getDriver().findElement(By.xpath("//input[@placeholder='" + arg1 + "']")).sendKeys("Samsung Galaxy S10");
		Driver.getDriver().findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	}

	@Then("^User click on criteria$")
	public void user_click_on() throws Throwable {
		Driver.getDriver().findElement(By.xpath("//a[text()='Mobiles']")).click();
		Driver.getDriver().findElement(By.xpath("//div[text()='SAMSUNG']")).click();

		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("arguments[0].click()", Driver.getDriver().findElement(By.className("_3U-Vxu")));
		jse.executeScript("arguments[0].click()",
				Driver.getDriver().findElement(By.xpath("//div[text()='Price -- High to Low']")));
	}

	@Then("^User prints the list of phones$")
	public void user_prints_the_list_of_phones() throws Throwable {
		List<WebElement> itemsList = Driver.getDriver().findElements(By.xpath("//div[@class='_1AtVbE col-12-12']"));

		for (WebElement item : itemsList) {
			String productName = item.findElement(By.xpath("//a//img[@class='_396cs4 _3exPp9']")).getAttribute("alt");
			String displayPrice = item.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1']")).getText();
			String link = item.findElement(By.xpath("//a//img[@class='_396cs4 _3exPp9']")).getAttribute("src");
			System.out.println(productName + "|" + displayPrice + "|" + link);
		}
	}
	
		@Then("^User close the browser$")
		public void user_close_the_browser() throws Throwable {
			Driver.getDriver().quit();
}

}