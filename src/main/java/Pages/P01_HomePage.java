package Pages;


import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P01_HomePage {
    private final WebDriver driver;
    private final By Login_Button=By.xpath("//a[@href=\"/login\"]");
    private final By LoggedinUser=By.xpath("//a//b");
    private final By DeleteAccount=By.xpath("//a[@href='/delete_account']");
    private final By LogoutButton=By.xpath("//a[@href=\"/logout\"]");
private final By ProductButton=By.xpath("//a[@href='/products']");

    public P01_HomePage(WebDriver driver) {
        this.driver=driver;
    }
    public P02_Signup_LoginPage ClickSignUp(){
        Utilities.ClickElement(driver,Login_Button);
        return new P02_Signup_LoginPage(driver);
    }

    public String GetLogginUser(){
        return Utilities.GetData(driver,LoggedinUser);

    }
    public P05_AcountDeletedPage DeleteAccount(){
        Utilities.ClickElement(driver,DeleteAccount);
        return new  P05_AcountDeletedPage(driver) ;
    }
    public boolean CheckUserLogin(String name){
        return GetLogginUser().equals(name);
    }
    public P02_Signup_LoginPage Logout(){
        Utilities.ClickElement(driver,LogoutButton);
        return new P02_Signup_LoginPage(driver);
    }
    public P06_ProductsPage ProductsButton(){
        Utilities.ClickElement(driver,ProductButton);
        return new P06_ProductsPage(driver);
    }


}
