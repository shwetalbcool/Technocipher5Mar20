package com.tc.caapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.StaticInitializerCoercer;

public class BaseTest {
	
	public static WebDriver driver;
	public static String projectPaath=System.getProperty("user.dir");
	public static  Properties p;

	
public static void init() throws Exception {
	FileInputStream fis=new FileInputStream(projectPaath+"//data.properties");
	 p= new Properties();
	p.load(fis);
	
}
	
public static void launchBrowser(String browser) {
		if(p.get(browser).equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver=new ChromeDriver();		
		}
		else if (p.get(browser).equals("firefox")) {
			System.setProperty("webdriver.geco.driver", System.getProperty("user.dir")+"//drivers//gecodriver.exe");
			driver=new FirefoxDriver();
			
		}
}
		
public static void  launchUrl(String url)
{
	driver.get(p.getProperty(url));
}
		
	}

	 /*public static void main(String[] args) {
		WebDriver driver;
		driver= new ChromeDriver();
		driver.get("http://ca-oms.com/");
		driver= new FirefoxDriver();
		driver.get("http://ca-oms.com/");
	}
*/
