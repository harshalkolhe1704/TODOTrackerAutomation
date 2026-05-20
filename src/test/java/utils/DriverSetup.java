package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	private static WebDriver driver;
    public static WebDriver getDriver()
	{
	    if(driver == null){
           /* System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            FirefoxProfile profile=new FirefoxProfile();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
            firefoxOptions.setProfile(profile);
            driver=new FirefoxDriver(firefoxOptions);*/
	    	driver=new ChromeDriver();
	    }
        return driver;
	}
        
}
