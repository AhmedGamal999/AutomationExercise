package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Signup_LoginPage {
    private  final WebDriver driver;
    private final By NameFieldSignUp =By.xpath("//input[@type='text']");
    private final By EmailFieldSignUp =By.xpath("//form[@action='/signup']//input[@type='email']");
    private final By SignupButton=By.xpath("//form[@action='/signup']//button[@type='submit']");
    private final By EmailFieldLogin=By.xpath("//form[@action='/login']//input[@type='email']");
    private final By PasswordFieldLogin=By.xpath("//form[@action='/login']//input[@type='password']");
    private final By LoginButton =By.xpath("//form[@action='/login']//button");
    private final By IncorrectDataMsg=By.xpath("//p[@style]");
    public P02_Signup_LoginPage(WebDriver driver) {
        this.driver=driver;

    }
    public P02_Signup_LoginPage SendNameSignUp(String name){
        Utilities.SendData(driver, NameFieldSignUp,name);
        return this;
    }
    public P02_Signup_LoginPage SendEmailSignUp(String email){
        Utilities.SendData(driver, EmailFieldSignUp,email);
        return this;
    }
    public P03_InformationPage ClickSignup(){
        Utilities.ClickElement(driver,SignupButton);
        return new P03_InformationPage(driver);
    }
    public P02_Signup_LoginPage SendEmailLogin(String email){
        Utilities.SendData(driver,EmailFieldLogin,email);
        return this;
    }
    public P02_Signup_LoginPage SendPasswordLogin(String key){
        Utilities.SendData(driver,PasswordFieldLogin,key);
        return this;
    }
    public P01_HomePage ClickLogin(){

        Utilities.ClickElement(driver,LoginButton);
        return new P01_HomePage(driver);
    }
    public String IncorrectDataMSG(){

        return  Utilities.GetData(driver,IncorrectDataMsg);
    }




}
