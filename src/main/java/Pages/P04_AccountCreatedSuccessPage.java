package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_AccountCreatedSuccessPage {
    private final  WebDriver driver;
    private final By ContinueButton=By.xpath("//a[contains(@class,'tn-primary')]");

    public P04_AccountCreatedSuccessPage(WebDriver driver) {
        this.driver=driver;
    }
    public P01_HomePage ContinueButton(){
        Utilities.ClickElement(driver,ContinueButton);
        return new P01_HomePage(driver);
    }
}
