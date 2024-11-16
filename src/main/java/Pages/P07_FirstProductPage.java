package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_FirstProductPage {
    private final WebDriver driver;
    private final By ProductName=By.xpath("//div[@class='product-information']//h2");
    private final By ProductCategory=By.xpath("//div[@class='product-information']//p");
    private final By ProductPrice=By.xpath("//span[text()='Rs. 500']");
    private final By ProductAvailability=By.xpath("//b[text()='Availability:']");
    private final By ProductCondition=By.xpath("//b[text()='Condition:']");

    public P07_FirstProductPage(WebDriver driver) {
        this.driver=driver;
    }
    public boolean CheckProductInfoVisability(){
       return Utilities.Visability(driver,ProductAvailability) &
               Utilities.Visability(driver,ProductCategory)&
               Utilities.Visability(driver,ProductCondition)&
               Utilities.Visability(driver,ProductPrice)&
               Utilities.Visability(driver,ProductName);

    }

}
