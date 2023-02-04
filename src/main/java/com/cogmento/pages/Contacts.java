package com.cogmento.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class Contacts extends Home {

    public Contacts(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//button[@class='ui linkedin button' and text()='Create']")
    private WebElement createNewContactBtn;

    public void createContacts(HashMap<String, String> data) {
        navigate("Contacts");
        createNewContactBtn.click();
    }


}
