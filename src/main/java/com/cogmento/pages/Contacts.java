package com.cogmento.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class Contacts extends Home {

    public Contacts(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "(//button[normalize-space()='Create'])[1]")
    protected WebElement createContactButton;

    @FindBy(name = "first_name")
    private WebElement firstNameInput;

    @FindBy(name = "last_name")
    private WebElement lastNameInput;

    @FindBy(name = "middle_name")
    private WebElement middleNameInput;

    @FindBy(xpath = "//div[@name='company']/input")
    private WebElement companyInput;

    @FindBy(xpath = "//button[@class='ui small fluid positive toggle button']")
    private WebElement accessBtn;

    @FindBy(xpath = "//div[@class='twelve wide field']")
    private WebElement usersAllowedAccess;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[3]/div[2]/div/label[2]/div/input")
    private WebElement tagsInput;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Email address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='name' and @placeholder='Personal email, Business, Alt...']")
    private WebElement typeOfEmail;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::div//button")
    private WebElement addEmailIcon;

    @FindBy(xpath = "//label[text()='Category']/following-sibling::div[@name='category']")
    private WebElement categoryInput;

    @FindBy(xpath = "//label[text()='Status']/following-sibling::div[@name='status']")
    private WebElement statusInput;

    @FindBy(name = "description")
    private WebElement descriptionTextarea;

    @FindBy(xpath = "//div[@name='channel_type']")
    private WebElement socialChannel;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div//input")
    private WebElement socialChannelLink;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div//button")
    private WebElement addSocialChannelIcon;

    @FindBy(xpath = "//label[text()='Time Zone']/following-sibling::div[@name='timezone']/input")
    private WebElement timeZoneInput;

    @FindBy(name = "address")
    private WebElement streetInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "state")
    private WebElement stateInput;

    @FindBy(name = "zip")
    private WebElement zipInput;

    @FindBy(xpath = "//div[@name='country']")
    private WebElement countryDropDown;

    @FindBy(xpath = "//label[text()='Address']/following-sibling::div//button")
    private WebElement addAddressIcon;

    @FindBy(xpath = "//div[@name='hint']/input")
    private WebElement region;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Number']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='name' and @placeholder='Home, Work, Mobile...']")
    private WebElement typeOfPhone;

    @FindBy(xpath = "//label[text()='Phone']/following-sibling::div//button")
    private WebElement addNumberIcon;

    @FindBy(name = "position")
    private WebElement positionInput;

    @FindBy(name = "department")
    private WebElement departmentInput;

    @FindBy(xpath = "//div[@name='supervisor']/input")
    private WebElement supervisorInput;

    @FindBy(xpath = "//div[@name='assistant']/input")
    private WebElement assistantInput;

    @FindBy(xpath = "//div[@name='referred_by']/input")
    private WebElement referredByInput;

    @FindBy(xpath = "//label[text()='Source']/following-sibling::div")
    private WebElement sourceDropDown;

    @FindBy(xpath = "//label[text()='Do not Call']/following-sibling::div")
    private WebElement doNotCallInput;

    @FindBy(xpath = "//label[text()='Do not Text']/following-sibling::div")
    private WebElement doNotTextInput;

    @FindBy(xpath = "//label[text()='Do not Email']/following-sibling::div")
    private WebElement doNotEmailInput;

    @FindBy(name = "day")
    private WebElement birthDay;

    @FindBy(xpath = "//div[@name='month']")
    private WebElement birthMonth;

    @FindBy(name = "year")
    private WebElement birthYear;

    @FindBy(name = "identifier")
    private WebElement identifierInput;

    @FindBy(name = "image")
    private WebElement imageInput; // we need to send the path of the picture based on the OS

    @FindBy(xpath = "//button[@class='ui linkedin button' and text()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//button[@class='ui button' and text()='Cancel']  ")
    private WebElement cancelBtn;

    public void createContacts(HashMap<String, String> data){
        navigate("Contacts");
        softAssert.assertTrue(createContactButton.isEnabled(), "Create button is not enabled");
        createContactButton.click();


        firstNameInput.sendKeys(data.get("firstname"));
        lastNameInput.sendKeys(data.get("lastname"));
        middleNameInput.sendKeys(data.get("middlename"));
        companyInput.sendKeys(data.get("company"));

        if(!data.get("access").equals("Public")){
            accessBtn.click();
            usersAllowedAccess.sendKeys("Shakhzod");
        }

        tagsInput.sendKeys(data.get("tags")+Keys.ENTER);
        emailInput.sendKeys(data.get("email"));
        typeOfEmail.sendKeys(data.get("typeOfEmail"));

        categoryInput.click();
        WebElement category = driver.findElement(By.xpath("//div/div/span[text()='" + data.get("category") + "']"));
        category.click();

        statusInput.click();
        statusInput.findElement(By.xpath("//div/div/span[text()='"+data.get("status")+"']")).click();

        descriptionTextarea.sendKeys(data.get("description"));

        socialChannel.click();
        socialChannel.findElement(By.xpath("//div/div/span[text()='"+data.get("socialChannel")+"']")).click();

        socialChannelLink.sendKeys(data.get("channelLink"));

        timeZoneInput.sendKeys(data.get("timezone"));

        streetInput.sendKeys(data.get("street"));
        cityInput.sendKeys(data.get("city"));
        stateInput.sendKeys(data.get("state/county"));

        data.put("zip", (int)Double.parseDouble(data.get("zip"))+"");
        zipInput.sendKeys(data.get("zip"));

        countryDropDown.click();
        countryDropDown.findElement(By.xpath("//div/div/span[text()='"+data.get("country")+"']"));

        region.sendKeys(data.get("region"));
        phoneNumberInput.sendKeys(data.get("number"));
        typeOfPhone.sendKeys(data.get("phoneType"));
        positionInput.sendKeys(data.get("position"));
        departmentInput.sendKeys(data.get("department"));
        supervisorInput.sendKeys(data.get("supervisor"));
        assistantInput.sendKeys(data.get("assistant"));
        referredByInput.sendKeys(data.get("referredBy"));

        sourceDropDown.click();
        sourceDropDown.findElement(By.xpath("//div/div/span[text()='"+data.get("source")+"']")).click();

        if(data.get("call?").equals("yes")){
            doNotCallInput.click();
        }

        if(data.get("email?").equals("yes")){
            doNotEmailInput.click();
        }

        if(data.get("text?").equals("yes")){
            doNotTextInput.click();
        }

        data.put("birthday", (int)Double.parseDouble(data.get("birthday"))+"");
        birthDay.sendKeys(data.get("birthday"));

        birthMonth.click();
        birthMonth.findElement(By.xpath("//div/div/span[text()='"+data.get("birthmonth")+"']")).click();

        data.put("birthyear", (int)Double.parseDouble(data.get("birthyear"))+"");
        birthYear.sendKeys(data.get("birthyear"));
        identifierInput.sendKeys(data.get("identifier"));
         imageInput.sendKeys(data.get("imagePath"));

    }

}
