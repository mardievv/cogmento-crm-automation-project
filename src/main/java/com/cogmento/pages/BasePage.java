package com.cogmento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected final WebDriver driver;


    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver,this);
    }
}
