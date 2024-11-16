package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ProductsPage {
    private final WebDriver driver;
    private final By FirstItemViewProduct=By.xpath("//a[@href=\"/product_details/1\"]");
    public P06_ProductsPage(WebDriver driver) {
        this.driver=driver;
    }
    public P07_FirstProductPage FirstProductViewClick(){
        Utilities.ClickElement(driver,FirstItemViewProduct);
        return new P07_FirstProductPage(driver);
    }
}
