package Listeners;

import Utilities.LogUtilites;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itest implements ITestListener {
    public void onTestSuccess(ITestResult result) {

        LogUtilites.info("TestCase" + result.getName() + "Passed");
    }

    public void onTestSkipped(ITestResult result) {
        LogUtilites.info("TestCase " + result.getName() + "Skipped");
    }

    public void onTestStart(ITestResult result) {
        LogUtilites.info("TestCase " + result.getName() + "Started");
    }

}
