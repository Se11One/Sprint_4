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

    public void ClickOrderTopBotton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("Button_Button__ra12g")));
        orderTopBotton.click();
    }

    public void ClickOrderBottomBotton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']")));
        orderBottomBotton.click();
    }
    public void CheckOneQuestion(String expectText) {
        question_1.click();
        String actualText = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckTwoQuestion(String expectText) {
        question_2.click();
        String actualText = driver.findElement(By.id("accordion__panel-1")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckThreeQuestion(String expectText) {
        question_3.click();
        String actualText = driver.findElement(By.id("accordion__panel-2")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckFourQuestion(String expectText) {
        question_4.click();
        String actualText = driver.findElement(By.id("accordion__panel-3")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckFiveQuestion(String expectText) {
        question_5.click();
        String actualText = driver.findElement(By.id("accordion__panel-4")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckSixQuestion(String expectText) {
        question_6.click();
        String actualText = driver.findElement(By.id("accordion__panel-5")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckSevenQuestion(String expectText) {
        question_7.click();
        String actualText = driver.findElement(By.id("accordion__panel-6")).getText();
        Assert.assertEquals(actualText, expectText);
    }
    public void CheckEightQuestion(String expectText) {
        question_8.click();
        String actualText = driver.findElement(By.id("accordion__panel-7")).getText();
        Assert.assertEquals(actualText, expectText);
    }
}
