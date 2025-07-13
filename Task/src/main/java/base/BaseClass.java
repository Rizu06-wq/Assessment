package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected static WebDriver driver;
    protected static Properties prop;

    public BaseClass() {
        if (prop == null) {
            prop = new Properties();
            try (FileInputStream ip = new FileInputStream("src/test/resources/config.properties")) {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not load config.properties");
            }
        }
    }

    public void initWebDriver() {
        if (driver == null) {
            String browser = prop.getProperty("browser", "chrome").trim().toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public void openURL() {
        String url = prop.getProperty("url");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL is not defined in config.properties");
        }
        driver.get(url);
    }
    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(filePath));
    }
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            
            
        }
    }
}
