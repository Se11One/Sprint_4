package ru.praktikum.qa_scooter;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpOrderIsProcessed {
    WebDriver driver;

    public PopUpOrderIsProcessed(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button[text()='Посмотреть статус']")
    private WebElement refuseButton;
    @FindBy(xpath = ".//div[@class='Order_ModalHeader__3FDaJ']")
    private  WebElement orderStatus;

    public void checkOrderStatus() {

        String actualText = orderStatus.getText();
        // Ожидаемый текст
        String expectedText = "Заказ оформлен";
        Assert.assertTrue("Ошибка при оформлении заказа, попробуйте оформить заказ позже", actualText.contains(expectedText));
    }
}
