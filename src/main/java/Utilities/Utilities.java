package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utilities {
    private static final String ScreenPath="test-outputs/Screenshots/";
    public static void SendData(WebDriver driver, By locator, String data){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }
    public static void ClickElement(WebDriver driver,By locator){
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    public static void GetData(WebDriver driver,By locator){
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public static WebElement ByToWebelment(WebDriver driver, By loctor){

        return driver.findElement(loctor);
    }
    public static void Scroll(WebDriver driver,By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",ByToWebelment(driver,locator));
    }
    public static void  TakeScreenShot(WebDriver driver,String name) throws IOException {
        try {
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dist =new File(ScreenPath+name+"-"+timestamp()+".png");
            FileUtils.copyFile(src,dist);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static String timestamp(){
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());

    }
    public static boolean CheckRedirectPage(WebDriver driver,String URl){
        return driver.getCurrentUrl().equals(URl);
    }


}
