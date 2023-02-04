package com.cogmento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class BasePage {

    protected final WebDriver driver;

    protected final SoftAssert softAssert;

    protected Actions actions;

    public BasePage(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver,this);
    }
}
