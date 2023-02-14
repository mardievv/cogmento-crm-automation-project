package com.cogmento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.cogmento.config.ConfigReader.getProperties;

public class Login extends BasePage {

    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[text()='Sign Up']")
    private WebElement signupLink;

    @FindBy(xpath = "//div[@class='ui negative message']")
    private WebElement invalidLogin;


    public void navigateToLoginPage(){
        driver.get(getProperties("url"));
        Assert.assertEquals(driver.getTitle(), "Cogmento CRM","Titles do not match");

    }


    public void login(){
        verifyElements();
        emailInput.sendKeys(enterEmail(getProperties("email")));
        passwordInput.sendKeys(enterPassword(getProperties("password")));
        clickOnLoginBtn();
    }


    public void loginNegative(){
        verifyElements();
        emailInput.sendKeys("invalid@gmail.com");
        passwordInput.sendKeys("invalidPassword");
        clickOnLoginBtn();
        Assert.assertTrue(invalidLogin.isDisplayed(),"Invalid login is not displayed");
    }


    private void verifyElements(){
        // verify inputs
        Assert.assertTrue(emailInput.isEnabled() && passwordInput.isEnabled(),"Inputs are not enabled");

        //verify forgot password link
        Assert.assertTrue(forgotPasswordLink.isEnabled(), "Forgot password link is not enabled");

        //verify sign up link
        Assert.assertTrue(loginBtn.isEnabled(), "Sign Up link is not enabled");
    }


    private void clickOnLoginBtn(){
        Assert.assertTrue(loginBtn.isDisplayed() && loginBtn.isEnabled(), "Login Button is not enabled");
        loginBtn.click();
    }


    private String  enterEmail(String email){
        return email;
    }


    private String  enterPassword(String password){
        return password;
    }

}
