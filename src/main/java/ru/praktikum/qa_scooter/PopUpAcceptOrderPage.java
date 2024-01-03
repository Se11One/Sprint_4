package ru.praktikum.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

;

public class PopUpAcceptOrderPage {
    WebDriver driver;

    public PopUpAcceptOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button[text()='Нет']")
    private WebElement refuseButton;
    @FindBy(xpath = ".//button[text()='Да']")
    private WebElement agreeButton;


    public void actionButton(String nameButton) {
        WebElement actionButton = driver.findElement(By.xpath(".//button[text()='" + nameButton + "']"));
        actionButton.click();
    }
}