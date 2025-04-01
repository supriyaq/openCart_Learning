package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 

{

	
	public static WebDriver w1;
	public Logger logger;
	public Properties class1;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass (groups= {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"})
	public void setUp(String os,String browser) throws IOException
	{
		FileInputStream file=new FileInputStream("./src//test//resources//config.properties");
		class1=new Properties();
		class1.load(file);
		
		
		
		
		logger= LogManager.getLogger(this.getClass()); 
		
		
		
		if(class1.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
//			String url_hub="http://192.168.1.3:4444/wd/hub";
			String url_hub="http://localhost:4444/wd/hub";
			DesiredCapabilities cap=new DesiredCapabilities();
			
			
			//os
			switch(os.toLowerCase())
			{
			case "windows": cap.setPlatform(Platform.WIN11);break;
			case  "mac" : cap.setPlatform(Platform.MAC); break;
			case  "linux":cap.setPlatform(Platform.LINUX); break;
			default: System.out.println(" invalid os name"); return;
			}
			
			
			//browser//
			
			switch(browser.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			default : System.out.println( " Invalid browser name...."); return;
			
			}
			
			
			
			w1=new RemoteWebDriver(new URL(url_hub),cap);
			
			
		}
		
		

		if(class1.getProperty("execution_env").equalsIgnoreCase("local"))
		{

			switch(browser.toLowerCase())
			{
			case "chrome": w1=new ChromeDriver(); break;
			case "firefox": w1=new FirefoxDriver(); break;
			case "edge": w1=new EdgeDriver(); break;
			default : System.out.println("Invalid browser name...."); return;
			}
			
		}
		
		
		
		
//		w1.get("https://tutorialsninja.com/demo/");
		w1.get(class1.getProperty("URL1"));
		w1.manage().deleteAllCookies();
		w1.manage().window().maximize();
		w1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	
	@AfterClass (groups= {"Sanity","Regression","Master","DataDriven"})
	public void tearDown()
	{
		w1.quit();
		
	}
	

	public String randomString()
	{
		@SuppressWarnings("deprecation")
		String s1=RandomStringUtils.randomAlphabetic(5);
		return s1;
	}
	
	
	
	public String randomNumber()
	{
		@SuppressWarnings("deprecation")
		String s2=RandomStringUtils.randomNumeric(10);
		return s2;
	}
	
	public String alphaNumeric()
	{
		@SuppressWarnings("deprecation")
		String s1=RandomStringUtils.randomAlphabetic(5);
		@SuppressWarnings("deprecation")
		String s2=RandomStringUtils.randomNumeric(10);
		String s3= s1+ "!" +s2;
		return s3;
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) w1;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
	
	

}
