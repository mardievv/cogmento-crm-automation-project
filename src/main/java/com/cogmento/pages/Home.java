package com.cogmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class Home extends BasePage {

    public Home(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='header item']")
    protected WebElement logo;

    @FindBy(xpath = "//div[@class='header item']/following-sibling::b")
    protected WebElement orgName;

    @FindBy(xpath = "//span[@class='user-display']")
    protected WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Search']")
    protected WebElement searchInput;

    @FindBy(xpath = "//button[@class='ui basic icon button']")
    protected WebElement pinBtn;

    @FindBy(xpath = "//button[@class='ui basic button item']")
    protected WebElement deleteBtn;

    @FindBy(xpath = "//div[@class='ui basic button floating item dropdown']")
    protected WebElement settingsGear;

    @FindBy(id = "main-nav")
    protected WebElement leftNavBarMenu;

    @FindBy(xpath = "//div[@class='menu-item-wrapper']//span[text()='Contacts']")
    private WebElement contacts;



    private String xpath(String path){
        return "//span[text()='"+path+"']";
    }

    protected void navigateToProduct(){
        settingsGear.click();
        WebElement logoutLink = driver.findElement(By.xpath(xpath("Products")));
        logoutLink.click();
    }

    protected void navigateToImport(){
        settingsGear.click();
        WebElement logoutLink = driver.findElement(By.xpath(xpath("Import")));
        logoutLink.click();
    }

    protected void navigateToTools(){
        settingsGear.click();
        WebElement logoutLink = driver.findElement(By.xpath(xpath("Tools")));
        logoutLink.click();
    }

    protected void logout(){
        settingsGear.click();
        WebElement logoutLink = driver.findElement(By.xpath(xpath("Log Out")));
        logoutLink.click();
    }

    protected void navigate(String page){
        WebElement pageLink = driver.findElement(By.xpath("//div[@class='menu-item-wrapper']//span[text()='"+page+"']"));
        actions.moveToElement(leftNavBarMenu).build().perform();
        Assert.assertTrue(pageLink.isEnabled(),"Page link is not enabled");
        pageLink.click();

    }

}
