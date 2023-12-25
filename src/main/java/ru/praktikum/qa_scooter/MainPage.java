package ru.praktikum.qa_scooter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "rcc-confirm-button")
    private  WebElement cookieButton;

    @FindBy(id = "accordion__heading-0")
    private  WebElement question_1;

    @FindBy(xpath = ".//*[@id='accordion__heading-1']")
    private WebElement question_2;

    @FindBy(xpath = ".//*[@id='accordion__heading-2']")
    private WebElement question_3;

    @FindBy(xpath = ".//*[@id='accordion__heading-3']")
    private WebElement question_4;

    @FindBy(xpath = ".//*[@id='accordion__heading-4']")
    private WebElement question_5;

    @FindBy(xpath = ".//*[@id='accordion__heading-5']")
    private WebElement question_6;

    @FindBy(xpath = ".//*[@id='accordion__heading-6']")
    private WebElement question_7;

    @FindBy(xpath = ".//*[@id='accordion__heading-7']")
    private WebElement question_8;


    public void AcceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("rcc-confirm-button")));
        cookieButton.click();
    }

    public void CheckResponse() {
        question_1.click();
        String actualText = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals(actualText, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }




    /*public void checkResponse(WebElement question, String expectedText) {
        // Прокручиваем страницу к элементу
        scrollToElement(question);

        // Кликаем по вопросу
        question.click();

        // Ожидаем появления панели
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement panel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='accordion__panel-" + question.getAttribute("id").substring(question.getAttribute("id").lastIndexOf("-") + 1) + "']")));

        // Получаем текст и сравниваем
        String actualText = panel.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    *//* public void checkResponse() {
        checkResponse(question_1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
    }*/

}
