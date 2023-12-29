package ru.praktikum.qa_scooter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class CustomerPage {
    WebDriver driver;
    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='root']/div/div[2]/div[2]/div[1]/input")
    private WebElement firstCustomerNameInput;

    @FindBy(xpath = ".//*[@id='root']/div/div[2]/div[2]/div[2]/input")
    private WebElement lastCustomerNameInput;

    @FindBy(xpath = ".//*[@id='root']/div/div[2]/div[2]/div[3]/input")
    private WebElement OrderAddressInput;

    @FindBy(xpath = ".//*[@class='select-search__input']")
    private WebElement MetroStationInput;

    @FindBy(xpath = ".//*[@id='root']/div/div[2]/div[2]/div[5]/input")
    private WebElement CustomerPhoneInput;

    @FindBy(xpath = ".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement NextButton;


        public void FillingCustomerForm(String firstrName, String lastName, String orderAddress, String metroStation, String customerPhone) {
            firstCustomerNameInput.sendKeys(firstrName);
            lastCustomerNameInput.sendKeys(lastName);
            OrderAddressInput.sendKeys(orderAddress);
            MetroStationInput.click();
            WebElement station = driver.findElement(By.xpath(".//*[text()='" + metroStation + "']"));
            station.click();
            CustomerPhoneInput.sendKeys(customerPhone);
            NextButton.click();
    }
}
