package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ProductsPage {
    private final WebDriver driver;
    private final By FirstItemViewProduct=By.xpath("//a[@href=\"/product_details/1\"]");
    private final By Searchbar =By.xpath("//input[@type='text']");
    private final By Searchbutton=By.xpath("//button[@type='button']");
    private final By ProductName=By.xpath("//div[@class='productinfo text-center']//p");
    private final By ProductNameinfo=By.xpath("//div[@class='product-information']//h2");
    private final By ProductCategoryinfo =By.xpath("//div[@class='product-information']//p");
    private final By ProductPriceinfo =By.xpath("//span[text()='Rs. 500']");
    private final By ProductAvailabilityinfo =By.xpath("//b[text()='Availability:']");
    private final By ProductConditioninfo =By.xpath("//b[text()='Condition:']");
    private final By AddtoCart=By.xpath("//div[contains(@class,'productinfo' )]//a[@data-product-id='']");
    private final By ContinueShoppingButton=By.xpath("//button[text()='Continue Shopping']");
    private final By CartButton=By.xpath("//a[@href=\"/view_cart\"]");
    public P06_ProductsPage(WebDriver driver) {
        this.driver=driver;
    }
    public P06_ProductsPage FirstProductViewClick(){
        Utilities.ClickElement(driver,FirstItemViewProduct);
        return this;
    }
    public  P06_ProductsPage SearchProduct(String productname){
        Utilities.ClickElement(driver, Searchbar);
        Utilities.SendData(driver, Searchbar,productname);
        Utilities.ClickElement(driver,Searchbutton);
        return this;
    }
    public String Productname(){
        return Utilities.GetData(driver,ProductName);
    }
    public boolean CheckProductname(String name){
        return Productname().equals(name);
    }
    public boolean CheckProductInfoVisability(){
        return Utilities.Visability(driver, ProductAvailabilityinfo) &
                Utilities.Visability(driver, ProductCategoryinfo)&
                Utilities.Visability(driver, ProductConditioninfo)&
                Utilities.Visability(driver, ProductPriceinfo)&
                Utilities.Visability(driver,ProductNameinfo);

    }
    public P06_ProductsPage AddTwoProduct(String a,String b){
       By first= By.xpath("//div[contains(@class,'productinfo' )]//a[@data-product-id='"+a+"']");
       By second= By.xpath("//div[contains(@class,'productinfo' )]//a[@data-product-id='"+b+"']");
       Utilities.ClickElement(driver,first);
       Utilities.ClickElement(driver,ContinueShoppingButton);
       Utilities.ClickElement(driver,second);
       return this;

    }
    public P07_CartPage CartButtonClick(){
        Utilities.ClickElement(driver,CartButton);
        return new P07_CartPage(driver);
    }


}


