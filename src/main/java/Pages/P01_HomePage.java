package Pages;


import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P01_HomePage {
    private final WebDriver driver;
    private static By Login_Button=By.xpath("//a[@href=\"/login\"]");


    public P01_HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public P02_SignupPage ClickSignUp(){
        Utilities.ClickElement(driver,Login_Button);
        return new P02_SignupPage(driver);
    }

}
