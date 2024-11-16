package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_InformationPage {
    private WebDriver driver;
    private final By title=By.xpath("//input[@value=\"Mr\"]");
    private final By Name=By.id("name");
    private final By Email=By.id("email");
    private final By Password=By.id("password");
    private final By Day=By.id("days");
    private final By Month=By.id("months");
    private final By Year=By.id("years");
    private final By NewsletterBox=By.id("newsletter");
    private final By ReceiveOffersButton =By.id("optin");
    private final By FirstName=By.id("first_name");
    private final By LastName=By.id("last_name");
    private final By Company=By.id("company");
    private final By Address_1=By.id("address1");
    private final By Address_2=By.id("address2");
    private final By Country=By.id("country");
    private final By State=By.id("state");
    private final By City=By.id("city");
    private final By ZipCode=By.id("zipcode");
    private final By Mobile_Number=By.id("mobile_number");
    private final By CreateAccountButton=By.xpath("//button[@data-qa='create-account']");





    public P03_InformationPage(WebDriver driver) {
        this.driver=driver;
    }
    public String GetName(){
        return Utilities.GetData(driver,Name);
    }
    public String GetEmail(){
        return Utilities.GetData(driver,Email);
    }
    public P03_InformationPage SelectTitle(){
        Utilities.ClickElement(driver,title);
        return this;
    }
    public P03_InformationPage SendPassword(String pass){
        Utilities.SendData(driver,Password,pass);
        return this;
    }
    public P03_InformationPage SelectBirthDate(String day , String month,String year){
        Utilities.SelectFromDropDown(driver,Day,day);
        Utilities.SelectFromDropDown(driver,Month,month);
        Utilities.SelectFromDropDown(driver,Year,year);
        return this;
    }
    public P03_InformationPage NewsletterBox(){
        Utilities.ClickElement(driver,NewsletterBox);
        return this;
    }
    public P03_InformationPage ReceiveOffersBox(){
        Utilities.ClickElement(driver,ReceiveOffersButton);
        return this;
    }
    public P03_InformationPage FirstName(String FName){
        Utilities.SendData(driver,FirstName,FName);
        return this;
    }
    public P03_InformationPage LastName(String LName){
        Utilities.SendData(driver,LastName,LName);
        return this;
    }
   public P03_InformationPage CompanyName(String company){
        Utilities.SendData(driver,Company,company);
        return this;
   }
   public P03_InformationPage State(String state){
        Utilities.SendData(driver,State,state);
        return this;
   }
    public P03_InformationPage Address_1(String address){
        Utilities.SendData(driver,Address_1,address);
        return this;
    }
    public P03_InformationPage Address_2(String address){
        Utilities.SendData(driver,Address_2,address);
        return this;
    }
    public P03_InformationPage Country(String key){
        Utilities.SelectFromDropDown(driver,Country,key);
        return this;
    }
    public P03_InformationPage City(String city){
        Utilities.SendData(driver,City,city);
        return this;
    }
    public P03_InformationPage ZipCode(String key){
        Utilities.SendData(driver,ZipCode,key);
        return this;
    }
    public P03_InformationPage Mobile_Number(String number){
        Utilities.SendData(driver,Mobile_Number,number);
        return this;
    }
    public P04_AccountCreatedSuccessPage CreatAccountButton(){
        Utilities.ClickElement(driver,CreateAccountButton);
        return new P04_AccountCreatedSuccessPage(driver);
    }

}
