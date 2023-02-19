package com.cogmento;

import com.cogmento.pages.Companies;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CompaniesTest extends BaseTest{

    @Test(dataProvider = "companies")
    public void createCompanies(HashMap<String,String> data) throws InterruptedException {
        extentTest = extentReports.startTest("Cogmento CRM Companies test");

        Login login = new Login(driver);
        login.navigateToLoginPage();
        login.login();

        Companies companies = new Companies(driver);
        companies.createCompaniesForm(data);
        Thread.sleep(5000);
    }

    @DataProvider(name = "companies")
    public Object[][] getContactData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/contactData/CogmentoTestData.xlsx", "companies");
        Object[][] data = excelReader.getData();
        return data;
    }
}
