package com.cogmento;

import com.cogmento.pages.Contacts;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ContactsTest extends BaseTest{


    @Test(dataProvider = "contacts")
    public void createPositiveContact(HashMap<String,String> data){
        extentTest = extentReports.startTest("Cogmento CRM Contact test");

        Login login = new Login(driver);
        extentTest.log(LogStatus.INFO,"Created Login Page");

        Contacts contacts = new Contacts(driver);
        extentTest.log(LogStatus.INFO,"Created Contact Page");

        login.navigateToLoginPage();
        extentTest.log(LogStatus.PASS,"Navigated to login page");

        login.login();
        extentTest.log(LogStatus.PASS,"Was able to log in");

        contacts.createContacts(data);
        extentTest.log(LogStatus.PASS,"Created new contact successfully");
    }

    @DataProvider(name = "contacts")
    public Object[][] getContactData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/contactData/CogmentoTestData.xlsx", "contacts");
        Object[][] data = excelReader.getData();
        return data;
    }
}
