package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static final ThreadLocal<WebDriver> driver =new ThreadLocal<>();

    public static void SetupDriver(String browser){
        switch (browser.toLowerCase()){
            case "edge":
                EdgeOptions options=new EdgeOptions();
                options.addArguments("--start-maximized");
                driver.set(new EdgeDriver(options));
                break;
            default:

                ChromeOptions Coptions=new ChromeOptions();
                Coptions.addArguments("--start-maximized");
                driver.set(new ChromeDriver(Coptions));

                break;


        }
    }
    public static WebDriver getdriver(){
        return driver.get();
    }
    public static void Quit(){
        getdriver().quit();
    }

}
