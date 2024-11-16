package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_AcountDeletedPage {
    private final WebDriver driver;
    private final By Continue=By.xpath("//a[contains(@class,'tn-primary')]");

    public P05_AcountDeletedPage(WebDriver driver) {
        this.driver=driver;
    }
    public P01_HomePage ContinueButton(){
        Utilities.ClickElement(driver,Continue);
        return new P01_HomePage(driver);
    }

}
