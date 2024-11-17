package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P07_CartPage {
    private  WebDriver driver;
    private final By ProductsAtCartQuantity=By.xpath("//button[@class='disabled']");
    public P07_CartPage(WebDriver driver) {
        this.driver=driver;
    }
    public String GetProductAtCartQuantity(){
        List<WebElement> quantity=driver.findElements(ProductsAtCartQuantity);
        return String.valueOf(quantity.size());
    }
    public boolean ChecktheQuantity(){
        return GetProductAtCartQuantity().equals("2");
    }
}
