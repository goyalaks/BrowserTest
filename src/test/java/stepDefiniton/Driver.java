package stepDefiniton;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	private static WebDriver driver = null;
	private static String currentDir = System.getProperty("user.dir");
	private static String browser = "";

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initiateDriver(String browser) throws Exception {
		if (driver == null) {
			switch (browser) {
			case "firefox":
				 DesiredCapabilities cap = DesiredCapabilities.firefox();
				 cap.setCapability("marionette", true);
				System.setProperty("webdriver.gecko.driver", currentDir + "/driver/geckodriver.exe");
				driver = new FirefoxDriver(cap);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", currentDir + "/driver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				throw new Exception("Browser is not correct");
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
