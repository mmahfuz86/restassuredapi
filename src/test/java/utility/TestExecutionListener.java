package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener implements ITestListener {
    private ExtentReports extent; // Report Manager
    private ExtentSparkReporter spark; //Report writer
    private ExtentTest eachTestCase; // Each test case

    // === Test Context Related === //

    public void onStart(ITestContext testContext) {
        String reportPath = System.getProperty("user.dir") + "/reports/result.html";
        extent.flush();
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
        //eachTestCase = extent.createTest(testcase.getName())

    }

    // === Test Cases Related === //
    public void onTestStart(ITestResult iTestResult) {
        //eachTestCase = extent.createTest(testcase.getName());
        Steps.init(eachTestCase);

    }


    public void onTestSuccess(ITestResult iTestResult) {

    }


    public void onTestFailure(ITestResult iTestResult) {

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


}
