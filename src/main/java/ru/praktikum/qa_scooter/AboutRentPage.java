package ru.praktikum.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutRentPage {
    WebDriver driver;
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='* Когда привезти самокат']")
    private WebElement deliveryDateInput;
    @FindBy(xpath = ".//*[@class='Dropdown-placeholder']")
    private WebElement rentalPeriodInput;
    @FindBy(css = "input[placeholder='Комментарий для курьера']")
    private WebElement commentInput;
    @FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[1]")
    private WebElement backButton;
    @FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[2]")
    private WebElement orderButton;

    public void fillingAboutRentForm(String deliveryDate, String  periodInput, String scooterColor, String comment){
        deliveryDateInput.sendKeys(deliveryDate);

        orderButton.click();

        rentalPeriodInput.click();
        WebElement period = driver.findElement(By.xpath("//*[@class='Dropdown-option' and text()='"+ periodInput + "']"));
        period.click();
        WebElement colour = driver.findElement(By.xpath(".//*[@id='"+scooterColor+"']"));
        colour.click();
        commentInput.sendKeys(comment);
        orderButton.click();
    }

}
