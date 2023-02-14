package com.cogmento;

import com.cogmento.pages.Contacts;
import com.cogmento.pages.Login;
import com.cogmento.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ContactsTest extends BaseTest{


    @Test(dataProvider = "contacts")
    public void createPositiveContact(HashMap<String,String> data){
        Login login = new Login(driver);
        Contacts contacts = new Contacts(driver);

        login.navigateToLoginPage();
        login.login();
        contacts.createContacts(data);
    }

    @DataProvider(name = "contacts")
    public Object[][] getContactData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/contactData/CogmentoTestData.xlsx", "contacts");
        Object[][] data = excelReader.getData();
        return data;
    }
}
