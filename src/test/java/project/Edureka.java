package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Edureka {
	
	public static WebDriver driver;
	static Properties prop= new Properties();
	
	public static void browserinvoke() {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	public static void browsermanage() {
		driver.manage().window().maximize();
	}
	
	public static void propertyfile() throws IOException {
		String file="./Input.properties";
		File ofile=new File(file);
		FileInputStream ifile=new FileInputStream(ofile);
		prop.load(ifile);
		System.out.println(prop.getProperty("URL"));
	}
	
	public static void launchurl() throws IOException {
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		screenshot();
	}
	
	public static void screenshot() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("./Screenshot/"+"screen"+System.currentTimeMillis()+".png"));
	}
	public static void main(String[] args) throws IOException {
		propertyfile();
		browserinvoke();
		browsermanage();
		launchurl();
	}


}
