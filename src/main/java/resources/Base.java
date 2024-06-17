package resources;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Properties prop;

    public WebDriver initializeBrowser() throws IOException {
        prop = new Properties();
        String proPath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
        FileInputStream fis = new FileInputStream(proPath);
        prop.load(fis);

        String browserName = prop.getProperty("browser");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setCapability("acceptInsecureCerts", true);
            if (headless) {
                options.addArguments("--headless"); // Enable headless mode
                options.addArguments("--no-sandbox");
                options.addArguments("--window-size=1920,1080"); // Set window size for headless mode
                options.addArguments("--disable-gpu"); // Disable GPU acceleration
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--allow-insecure-localhost");
                
            }
            driver.set(new ChromeDriver(options));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            if (headless) {
                options.addArguments("--headless"); // Enable headless mode
            }
            driver.set(new FirefoxDriver(options));
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void quitDriver() {
        getDriver().quit();
        driver.remove();
    }

    public String takeScreenshot(String testName, WebDriver driver) throws IOException {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + ".png";
        FileUtils.copyFile(sourceFile, new File(destinationFilePath));
        return destinationFilePath;
    }
}
