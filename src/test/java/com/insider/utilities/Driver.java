package com.insider.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class Driver {
    private  Driver(){

}

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){
            /*
            We read our browserType from configuration.properties
            This way we can control which browser is opened from outside code, from configuration.properties
            */
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                    break;
            }

        }

        return driver;

    }

    /*
    This method will make sure our driver value is always null after using quit() method
    */
    public static void closeDriver(){
        if (driver != null){
            driver.quit();  //this line will terminate the existing session. value will not be null
            driver = null;
        }
    }

}

