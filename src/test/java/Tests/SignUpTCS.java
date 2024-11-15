package Tests;

import DriverFactory.Driver;
import Pages.P01_HomePage;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.Driver.getdriver;
@Listeners({Itest.class, IInvoked.class})
public class SignUpTCS {
    @BeforeMethod
    public void setup() throws IOException {
        Driver.SetupDriver("chrom");
        getdriver().get(DataUtilies.GetDataFromEnvironment("environment","Home_page"));
        LogUtilites.info("Chrom is Running");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void Signup() throws IOException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendName(DataUtilies.GetDataJson("SignUpData","name"))
                .SendEmail(DataUtilies.GetDataJson("SignUpData","email"))
                .ClickSignup();
        Assert.assertTrue(Utilities.CheckRedirectPage(getdriver(),
                DataUtilies.GetDataFromEnvironment("environment",
                        "AccountInformation_Page")));
    }



    @AfterMethod
    public void Quit(){
        Driver.Quit();
    }
}
