package utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Tor_browser {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        //driver = new HtmlUnitDriver();    
        //driver = new FirefoxDriver();
    	System.setProperty("webdriver.gecko.driver", "C:\\Tor\\geckodriver.exe");
        String torPath = "C:\\Tor\\Browser\\TorBrowser\\Tor\\tor.exe";
        String profilePath = "C:\\Tor\\Browser\\TorBrowser\\Data\\Browser\\profile.default";
        FirefoxProfile profile = new FirefoxProfile(new File(profilePath));
        FirefoxBinary binary = new FirefoxBinary(new File(torPath));
        
        
        driver = new FirefoxDriver(binary, profile);        
        baseUrl = "https://qa2all.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/");

    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private void fail(String verificationErrorString) {
        // TODO Auto-generated method stub

    }
}

