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
public class CreatAccountTCs {
    @BeforeMethod
    public void setup() throws IOException {
        Driver.SetupDriver("chrom");
        getdriver().get(DataUtilies.GetDataFromEnvironment("environment","Home_page"));
        LogUtilites.info("chrom is Running");
        getdriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void CheckName() throws FileNotFoundException {
     String name=  new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendNameSignUp(DataUtilies.GetDataJson("SignUpData","name"))
                .SendEmailSignUp(DataUtilies.GetDataJson("SignUpData","email"))
                .ClickSignup().GetName();
        Assert.assertEquals(DataUtilies.GetDataJson("SignUpData","name")
                ,name);
    }@Test
    public void CheckEmail() throws FileNotFoundException {
        String email=  new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendNameSignUp(DataUtilies.GetDataJson("SignUpData","name"))
                .SendEmailSignUp(DataUtilies.GetDataJson("SignUpData","email"))
                .ClickSignup().GetEmail();
        Assert.assertEquals(DataUtilies.GetDataJson("SignUpData","email")
                ,email);
    }
    @Test(description = "TC1",groups = {"Task"})
    public void FillSignUpData() throws IOException {
      String name=  new P01_HomePage(getdriver())
                .ClickSignUp()
                .SendNameSignUp(DataUtilies.GetDataJson("SignUpData","name"))
                .SendEmailSignUp(DataUtilies.GetDataJson("SignUpData","email"))
                .ClickSignup()
                .SelectTitle()
                .SendPassword(DataUtilies.GetDataJson("SignUpData","Password"))
                .SelectBirthDate(DataUtilies.GetDataJson("SignUpData","Day"),
                        DataUtilies.GetDataJson("SignUpData","Month"  )
                        ,DataUtilies.GetDataJson("SignUpData","Year"))
                .NewsletterBox()
                .ReceiveOffersBox()
                .FirstName(DataUtilies.GetDataJson("SignUpData","FirstName"))
                .LastName(DataUtilies.GetDataJson("SignUpData","LastName"))
                .CompanyName(DataUtilies.GetDataJson("SignUpData","Company"))
                .Address_1(DataUtilies.GetDataJson("SignUpData","Address1"))
                .Country(DataUtilies.GetDataJson("SignUpData","Country"))
                .State(DataUtilies.GetDataJson("SignUpData","State"))
                .City(DataUtilies.GetDataJson("SignUpData","City"))
                .ZipCode(DataUtilies.GetDataJson("SignUpData","ZipCode"))
                .Mobile_Number(DataUtilies.GetDataJson("SignUpData","Mobile_number"))
                .CreatAccountButton().ContinueButton().GetLogginUser();
      LogUtilites.info(name);
        Assert.assertEquals(name,DataUtilies.GetDataJson("SignUpData","name"));
        LogUtilites.info("The account was created By Username " +name);
        new P01_HomePage(getdriver())
                .DeleteAccount()
                .ContinueButton();
        LogUtilites.info("the account is deleted");
        Assert.assertTrue(Utilities.CheckRedirectPage(getdriver(),
                DataUtilies.GetDataFromEnvironment("environment","Home_page")));


    }


        @AfterMethod
    public void Quit(){
        Driver.Quit();
    }

}
