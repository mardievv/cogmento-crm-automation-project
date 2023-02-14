package com.cogmento;

import com.cogmento.pages.Login;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void LoginPositiveTest(){
        extentTest = extentReports.startTest("Cogmento CRM Login Positive test");
        Login login = new Login(driver);
        extentTest.log(LogStatus.INFO,"Created login page");
        login.navigateToLoginPage();
        extentTest.log(LogStatus.INFO,"Navigated to login page");
        login.login();
        extentTest.log(LogStatus.PASS,"Was able to log in");
    }

    @Test
    public void LoginNegativeTest(){
        extentTest = extentReports.startTest("Cogmento CRM Login Negative test");
        Login login = new Login(driver);
        extentTest.log(LogStatus.INFO,"Created Login Page");
        login.navigateToLoginPage();
        extentTest.log(LogStatus.INFO,"Navigated to Login Page");
        login.loginNegative();
        extentTest.log(LogStatus.PASS,"Was not able to log in");
    }

}
