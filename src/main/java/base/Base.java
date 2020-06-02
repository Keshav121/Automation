package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class Base {
	
	public static WebDriver driver;
	public static AppiumDriver<MobileElement> appiumDriver;
	
	public static Properties prop;
	public static DesiredCapabilities cap;
	
	public  static AppiumDriverLocalService service;
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>(); //Create a Thread Local
	
	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driver) {
		dr.set(driver);
	}
	
	
	//Invoking Desktop Browsers
	public static WebDriver getDriver(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		setDriver(driver);
		
		return getDriver();
			
	}
	
	//Running baseUrl on Desktop browsers
	public static WebDriver getUrl() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\base\\global.properties");
		prop = new Properties();
		prop.load(fis);
		
		getDriver().get(prop.getProperty("baseUrl"));
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static AppiumDriver<MobileElement> capabilities(String mobileBrowser) throws IOException
	{
		if(mobileBrowser.equalsIgnoreCase("MobileChrome"))  //Launch the Chrome browser on Android
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\base\\global.properties");
			prop = new Properties();
			prop.load(fis);
			
			String device = (String) prop.get("deviceName");
			String platform = (String) prop.get("platformName");
			String platformVersion = (String) prop.get("platformVersion");
			String browser = (String) prop.get("browserName");
			
			cap = new DesiredCapabilities();
			cap.setCapability("deviceName", device);
			cap.setCapability("platformName", platform);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("browserName", browser);
			cap.setCapability("chromedriverExecutable",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe" );
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("w3c", false);
			cap.merge(chromeOptions);
			
			appiumDriver =new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		}
		else if(mobileBrowser.equalsIgnoreCase("safari"))
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\base\\global.properties");
			prop = new Properties();
			prop.load(fis);
			
			String iOSdevice = (String) prop.get("iOSDeviceName");
			String iOSplatformVersion = (String) prop.get("iOSPlatformVersion");
			String iOSbrowser = (String) prop.get("iOSBrowser");
			
			cap = new DesiredCapabilities();
			cap.setCapability("deviceName", iOSdevice);
			cap.setCapability("platformVersion", iOSplatformVersion);
			cap.setCapability("browserName", iOSbrowser);
			
			appiumDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		
		return appiumDriver;	
	}
	 
	//Running baseUrl on the Mobile Browser
	public AppiumDriver<MobileElement> getUrlOnMobile() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\base\\global.properties");
		prop = new Properties();
		prop.load(fis);
		appiumDriver.get(prop.getProperty("baseUrl"));
		return appiumDriver;
	}
	
	public AppiumDriverLocalService startServer()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
	}
	
	public void stopDriver()
	{
		getDriver().quit();
		
	}
	
	public void screenshot()
	{
		/* Need to work on the way it should be work now*/
	}
	

}
