package com.cogmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;

public class Companies extends Home{

    public Companies(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/companies/new']")
    private WebElement createNewCompany;

    @FindBy(xpath = "//div[@id='dashboard-toolbar']/div/div/button[@class='ui linkedin button']")
    private WebElement saveBtn;

    @FindBy(xpath = "//label[text()='Name']/following-sibling::div/div/input[@name='name']")
    private WebElement nameInput;

    @FindBy(xpath = "//label[text()='Access']/following-sibling::div/div/button")
    private WebElement accessBtn;

    @FindBy(xpath = "//div[text()='Select users allowed access.']")
    private WebElement accessInput;

    @FindBy(xpath = "//label[text()='Website']/following-sibling::div/input[@name='url']")
    private WebElement websiteInput;

    @FindBy(xpath = "//label[text()='Website']/following-sibling::div/button[text()='Fetch']")
    private WebElement websiteFetchBtn;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement streetInput;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@name='zip']")
    private WebElement zipInput;

    @FindBy(xpath = "//div[@name='country']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//label[text()='Address']/following-sibling::div/div/div/button")
    private WebElement addAddressIcon;

    @FindBy(xpath = "//div[@name='hint']")
    private WebElement region;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Number']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='name' and @placeholder='Home, Work, Mobile...']")
    private WebElement typeOfPhoneInput;

    @FindBy(xpath = "//label[text()='Phone']/following-sibling::div/div/div/button")
    private WebElement addPhoneNumberIcon;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Email address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='name' and @placeholder='Personal email, Business, Alt...']")
    private WebElement typeOfEmailInput;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::div/div/div/button")
    private WebElement addEmailIcon;

    @FindBy(xpath = "//label[@for='tags']/div")
    private WebElement tagsDropdown;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::textarea")
    private WebElement descriptionTextarea;

    @FindBy(name = "channel_type")
    private WebElement socialChannelDropDown;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Twitter handle']")
    private WebElement socialMediaLink;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div/div/div/button")
    private WebElement addSocialMediaIcon;

    @FindBy(name = "industry")
    private WebElement industryInput;

    @FindBy(name = "num_employees")
    private WebElement numOfemployees;

    @FindBy(name = "symbol")
    private WebElement stockSymbolInput;

    @FindBy(name = "annual_revenue")
    private WebElement annualRevenue;

    @FindBy(xpath = "//label[text()='Priority']/following-sibling::div[@name='priority']")
    private WebElement priorityDropdown;

    @FindBy(xpath = "//label[text()='Status']/following-sibling::div[@name='status']")
    private WebElement statusDropdown;

    @FindBy(xpath = "//label[text()='Source']/following-sibling::div[@name='source']")
    private WebElement sourceDropdown;

    @FindBy(xpath = "//label[text()='Category']/following-sibling::div[@name='category']")
    private WebElement categoryDropdown;

    @FindBy(name = "vat_number")
    private WebElement vatNumberInput;

    @FindBy(name = "identifier")
    private WebElement identifierInput;

    @FindBy(name = "image")
    private WebElement imageInput;




    public void createCompaniesForm(HashMap<String,String> data){
        navigate("Companies");
        Assert.assertEquals(driver.getTitle().trim(),"Cogmento CRM");
        createNewCompany.click();
        fillOutCompaniesForm(data);
    }

    private void fillOutCompaniesForm(HashMap<String,String> data){

        nameInput.sendKeys(data.get("Name"));

        if (!data.get("Access").equals("public")){
            accessBtn.click();
        }

        websiteInput.sendKeys(data.get("Website"));
        websiteFetchBtn.click();

        streetInput.sendKeys(data.get("Street Address"));
        cityInput.sendKeys(data.get("City"));
        stateInput.sendKeys(data.get("State"));
        zipInput.sendKeys(data.get("Postal Code"));

        countryDropdown.click();
        countryDropdown.findElement(By.xpath("//div/div/span[text()='"+data.get("Country")+"']")).click();



    }
}
