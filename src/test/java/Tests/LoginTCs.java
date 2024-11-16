package Tests;

import DriverFactory.Driver;
import Pages.P01_HomePage;
import Pages.P02_Signup_LoginPage;
import Utilities.DataUtilies;
import Utilities.LogUtilites;
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
public class LoginTCs {
    @BeforeMethod
    public void setup() throws IOException {
        Driver.SetupDriver("chrom");
        getdriver().get(DataUtilies.GetDataFromEnvironment("environment","Home_page"));
        LogUtilites.info("Chrom is Running");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(groups = {"Task"},description = "TC2")
    public void ValidLogin() throws IOException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendEmailLogin(DataUtilies.GetDataJson("LoginData","email"))
                .SendPasswordLogin(DataUtilies.GetDataJson("LoginData","password"))
                .ClickLogin().GetLogginUser();
      LogUtilites.info(new  P01_HomePage(getdriver()).GetLogginUser());
      Assert.assertTrue(new P01_HomePage(getdriver())
              .CheckUserLogin(DataUtilies.GetDataJson("LoginData","name")));
    }
    @Test(groups = {"Task"},description = "TC3")
    public void InvalidLogin() throws FileNotFoundException {
        new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendEmailLogin(DataUtilies.GetDataJson("LoginData","invalidemail"))
                .SendPasswordLogin(DataUtilies.GetDataJson("LoginData","password"))
                .ClickLogin();
       LogUtilites.info(new P02_Signup_LoginPage(getdriver()).
               IncorrectDataMSG());
        Assert.assertEquals( new P02_Signup_LoginPage(getdriver()).
                IncorrectDataMSG(),DataUtilies.GetDataJson("LoginData","incorrectDataMSg"));

    }


    @AfterMethod
    public void Quit(){
        Driver.Quit();
    }
}


