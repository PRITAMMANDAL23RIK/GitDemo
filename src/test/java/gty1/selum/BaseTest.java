package gty1.selum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import gty.selum.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage ld;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resource//GlobalVariable");
		prop.load(fis);
		String bro=prop.getProperty("browser");
		
		if(bro.equals("chrome")) {
			driver=new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public List<HashMap<String, String>> getDataToMap(String FilePath) throws IOException {
		String jsoncontent=FileUtils.readFileToString(new File(FilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>() {});
		return data;
	}
	
	public String takess(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"\\src\\test"+testcasename+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\src\\test"+testcasename+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		driver=initializeDriver();
		ld=new LandingPage(driver);
		ld.Goto();
		return ld;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closet() {
		driver.close();
	}

}
