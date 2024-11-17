package Tests;

import DriverFactory.Driver;
import Pages.P01_HomePage;
import Pages.P06_ProductsPage;
import Pages.P07_CartPage;
import Utilities.DataUtilies;
import Utilities.LogUtilites;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.IInvoked;
import Listeners.Itest;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.Driver.getdriver;
@Listeners({Itest.class, IInvoked.class})
public class ProductsPageTCs {
    @BeforeMethod
    public void setup() throws IOException {
        Driver.SetupDriver("chrom");
        getdriver().get(DataUtilies.GetDataFromEnvironment("environment","Home_page"));
        LogUtilites.info("Chrom is Running");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void CheckProductsBotton() throws IOException {
        new P01_HomePage(getdriver()).ProductsButton();
        Assert.assertTrue(Utilities.CheckRedirectPage(getdriver(),DataUtilies.
                GetDataFromEnvironment("environment","Products_Page")));

    }

    @Test(groups = {"Task"},description = "TC9")
    public void ProductSearch() throws IOException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendEmailLogin(DataUtilies.GetDataJson("LoginData","email"))
                .SendPasswordLogin(DataUtilies.GetDataJson("LoginData","password"))
                .ClickLogin()
                .ProductsButton()
                .SearchProduct(DataUtilies.GetDataJson("ProductData","Productname"))
                .Productname();
        LogUtilites.info(new P06_ProductsPage(getdriver()).Productname());
        Assert.assertTrue(new P06_ProductsPage(getdriver()).CheckProductname(DataUtilies.GetDataJson("ProductData","Productname")));


    }
    @Test(groups = {"Task"},description = "TC8")
    public void CheckProductinfoVisbility() throws IOException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendEmailLogin(DataUtilies.GetDataJson("LoginData","email"))
                .SendPasswordLogin(DataUtilies.GetDataJson("LoginData","password"))
                .ClickLogin()
                .ProductsButton()
                .FirstProductViewClick()
                .CheckProductInfoVisability();
        LogUtilites.info(String.valueOf(new P06_ProductsPage(getdriver()).CheckProductInfoVisability()));
        Assert.assertTrue(new P06_ProductsPage(getdriver()).CheckProductInfoVisability());

    }
    @Test(groups = {"Task"},description = "TC12,TC13")
    public void AddproductTocart() throws IOException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendEmailLogin(DataUtilies.GetDataJson("LoginData", "email"))
                .SendPasswordLogin(DataUtilies.GetDataJson("LoginData", "password"))
                .ClickLogin()
                .ProductsButton()
                .AddTwoProduct("1","2")
                .CartButtonClick()
                .GetProductAtCartQuantity();


        LogUtilites.info(new P07_CartPage(getdriver()).GetProductAtCartQuantity());
        Assert.assertTrue(new P07_CartPage(getdriver()).ChecktheQuantity());
    }

        @AfterMethod
    public void Quit(){
        Driver.Quit();
    }

}
