package Listeners;


import Utilities.Utilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

import static DriverFactory.Driver.getdriver;

public class IInvoked implements IInvokedMethodListener {
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test case" + testResult.getName() + " Failure");
            try {
                Utilities.TakeScreenShot(getdriver(), testResult.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
