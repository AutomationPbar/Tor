package utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Tor_browser_test {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
    	
    	setup();
    	
    }
     public static void setup(){
        FirefoxOptions options = new FirefoxOptions();
        /*
        File torProfileDir = new File(
                "...\\Tor Browser\\Data\\Browser\\profile.default");
        FirefoxBinary binary = new FirefoxBinary(new File(
                "...\\Tor Browser\\Start Tor Browser.exe"));
        FirefoxProfile torProfile = new FirefoxProfile(torProfileDir);
        torProfile.setPreference("webdriver.load.strategy", "unstable");

        try {
            binary.startProfile(torProfile, torProfileDir, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String profilePath = "C:\\Tor\\Browser\\TorBrowser\\Data\\Browser\\profile.default";
        */
                
       
        FirefoxProfile profile = new FirefoxProfile();
        
        profile.setPreference("webdriver.load.strategy", "unstable");
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.socks", "127.0.0.1");
        profile.setPreference("network.proxy.socks_port", 9050);
       
        options.setProfile(profile);
        options.setBinary("C:\\Tor\\Browser\\firefox.exe");
        
        System.setProperty("webdriver.gecko.driver", "C:\\Tor\\geckodriver.exe");
     
        
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();}
   
    @Test
    public void tor_browser_test() throws InterruptedException {
    	driver.get("http://check.torproject.org");
    	driver.get("https://iplocation.com");
    	
    	System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/table/tbody/tr[1]/td/b")).getText());
    	//driver.get("https://www.google.co.in");
    	//driver.findElement(By.name("q")).sendKeys("tor browser");
        Thread.sleep(15000);
        
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get("http://check.torproject.org");
        driver.get("https://iplocation.com");
    	
    	System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/table/tbody/tr[1]/td/b")).getText());
    	
    	
    	 Thread.sleep(15000);
         
    	 driver.manage().deleteAllCookies();
         driver.navigate().refresh();
         driver.get("http://check.torproject.org");
         driver.get("https://iplocation.com");
     	
     	System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/table/tbody/tr[1]/td/b")).getText());
    	
    }
}