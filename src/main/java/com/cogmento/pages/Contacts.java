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

    @FindBy(xpath = "//label[@for='tags']/div/input")
    private WebElement tagsInput;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Email address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='name' and @placeholder='Personal email, Business, Alt...']")
    private WebElement typeOfEmail;

    @FindBy(xpath = "//label[text()='Email']/following-sibling::div//button")
    private WebElement addEmailIcon;

    @FindBy(xpath = "//div[@name='category' and @class='ui selection upward dropdown']")
    private WebElement categoryInput;

    @FindBy(xpath = "//div[@name='status' and @class='ui selection upward dropdown']")
    private WebElement statusInput;

    @FindBy(name = "description")
    private WebElement descriptionTextarea;

    @FindBy(xpath = "//div[@name='channel_type']")
    private WebElement socialChannel;

    @FindBy(xpath = "//input[@name='value' and @placeholder='Twitter handle']")
    private WebElement twitterHandler;

    @FindBy(xpath = "//label[text()='Social Channels']/following-sibling::div//button")
    private WebElement addSocialChannelIcon;

    @FindBy(xpath = "//div[@name='timezone']/input")
    private WebElement timeZoneInput;

    @FindBy(name = "address")
    private WebElement addressInput;

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
    private WebElement phoneState;

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

    @FindBy(xpath = "//div[@name='source']//div[@class='divider default text']")
    private WebElement sourceDropDown;

    @FindBy(name = "do_not_call")
    private WebElement doNotCallInput;

    @FindBy(name = "do_not_text")
    private WebElement doNotTextInput;

    @FindBy(name = "do_not_email")
    private WebElement doNotEmailInput;

    @FindBy(name = "day")
    private WebElement birthDay;

    @FindBy(name = "month")
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

    public void createContacts(HashMap<String, String> data) {
        navigate("Contacts");
        createNewContactBtn.click();
    }


}
