package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_SignupPage {
    private  final WebDriver driver;
    private final By NameField=By.xpath("//input[@type='text']");
    private final By EmailField=By.xpath("//form[@action='/signup']//input[@type='email']");
    private final By SignupButton=By.xpath("//form[@action='/signup']//button[@type='submit']");
    public P02_SignupPage(WebDriver driver) {
        this.driver=driver;

    }
    public P02_SignupPage SendName(String name){
        Utilities.SendData(driver,NameField,name);
        return this;
    }
    public P02_SignupPage SendEmail(String email){
        Utilities.SendData(driver,EmailField,email);
        return this;
    }
    public P03_InformationPage ClickSignup(){
        Utilities.ClickElement(driver,SignupButton);
        return new P03_InformationPage(driver);
    }


}
