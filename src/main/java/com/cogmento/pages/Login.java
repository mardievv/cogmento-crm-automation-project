package com.cogmento.pages;

import com.cogmento.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static com.cogmento.config.ConfigReader.getProperties;

public class Login {

    private final WebDriver driver;

    private final SoftAssert softAssert;

    public Login(WebDriver driver, SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
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
        softAssert.assertEquals(driver.getTitle(), "Cogmento CRM","Titles do not match");

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
        softAssert.assertTrue(invalidLogin.isDisplayed(),"Invalid login is not displayed");
    }


    private void verifyElements(){
        // verify inputs
        softAssert.assertTrue(emailInput.isEnabled() && passwordInput.isEnabled(),"Inputs are not enabled");

        //verify forgot password link
        softAssert.assertTrue(forgotPasswordLink.isEnabled(), "Forgot password link is not enabled");

        //verify sign up link
        softAssert.assertTrue(loginBtn.isEnabled(), "Sign Up link is not enabled");
    }


    private void clickOnLoginBtn(){
        softAssert.assertTrue(loginBtn.isDisplayed() && loginBtn.isEnabled(), "Login Button is not enabled");
        loginBtn.click();
    }


    private String  enterEmail(String email){
        return email;
    }


    private String  enterPassword(String password){
        return password;
    }

}
