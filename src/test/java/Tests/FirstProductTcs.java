package Tests;

import DriverFactory.Driver;
import Pages.P01_HomePage;
import Pages.P07_FirstProductPage;
import Utilities.DataUtilies;
import Utilities.LogUtilites;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import Listeners.IInvoked;
import Listeners.Itest;
import static DriverFactory.Driver.getdriver;
@Listeners({Itest.class, IInvoked.class})
public class FirstProductTcs {
    @BeforeMethod
    public void setup() throws IOException {
        Driver.SetupDriver("chrom");
        getdriver().get(DataUtilies.GetDataFromEnvironment("environment","Home_page"));
        LogUtilites.info("Chrom is Running");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void CheckViewProductsBotton() throws IOException {
        new P01_HomePage(getdriver())
                .ProductsButton()
                .FirstProductViewClick();

        Assert.assertTrue(Utilities.CheckRedirectPage(getdriver(),DataUtilies.
                GetDataFromEnvironment("environment","FirstProduct_Page")));

    }

    @Test(groups = {"Task"},description = "TC8")
    public void CheckVisbility() throws IOException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendEmailLogin(DataUtilies.GetDataJson("LoginData","email"))
                .SendPasswordLogin(DataUtilies.GetDataJson("LoginData","password"))
                .ClickLogin()
                .ProductsButton()
                .FirstProductViewClick()
                .CheckProductInfoVisability();
        LogUtilites.info(String.valueOf(new P07_FirstProductPage(getdriver()).CheckProductInfoVisability()));
        Assert.assertTrue(new P07_FirstProductPage(getdriver()).CheckProductInfoVisability());

    }

    @AfterMethod
    public void Quit(){
        Driver.Quit();
    }


}
