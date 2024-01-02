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

    @FindBy(xpath =  ".//*[@class='Button_Button__ra12g']")
    private  WebElement orderTopBotton;

    @FindBy(xpath =  ".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private  WebElement orderBottomBotton;

    @FindBy(xpath = ".//*[@id='accordion__heading-0']")
    private  WebElement question1;

    @FindBy(xpath = ".//*[@id='accordion__heading-1']")
    private WebElement question2;

    @FindBy(xpath = ".//*[@id='accordion__heading-2']")
    private WebElement question3;

    @FindBy(xpath = ".//*[@id='accordion__heading-3']")
    private WebElement question4;

    @FindBy(xpath = ".//*[@id='accordion__heading-4']")
    private WebElement question5;

    @FindBy(xpath = ".//*[@id='accordion__heading-5']")
    private WebElement question6;

    @FindBy(xpath = ".//*[@id='accordion__heading-6']")
    private WebElement question7;

    @FindBy(xpath = ".//*[@id='accordion__heading-7']")
    private WebElement question8;


    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("rcc-confirm-button")));
        cookieButton.click();
    }

    public void clickOrderTopBotton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("Button_Button__ra12g")));
        orderTopBotton.click();
    }

    public void clickOrderBottomBotton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']")));
        orderBottomBotton.click();
    }

    public void checkOverQuestion(int numberQuest, String expectText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement questionElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='accordion__heading-" + (numberQuest - 1) + "']")));
        questionElement.click();

        WebElement panelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='accordion__panel-" + (numberQuest - 1) + "']")));

        String actualText = panelElement.getText();
        Assert.assertEquals(actualText, expectText);
    }
}
