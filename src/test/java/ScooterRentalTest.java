import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.qa_scooter.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScooterRentalTest {
    private final String firstName;
    private final String lastName;
    private final String orderAddress;
    private final String metroStation;
    private final String customerPhone;
    private final String deliveryDate;
    private final String periodInput;
    private final String scooterColor;

    WebDriver driver;

    public ScooterRentalTest(String firstName, String lastName, String orderAddress, String metroStation, String customerPhone, String deliveryDate, String periodInput, String scooterColor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderAddress = orderAddress;
        this.metroStation = metroStation;
        this.customerPhone = customerPhone;
        this.deliveryDate = deliveryDate;
        this.periodInput = periodInput;
        this.scooterColor = scooterColor;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getOrderData() {
        return Arrays.asList(new Object[][]{
                {"Питер", "Паркер", "Нью Йорк", "Лубянка", "42121234567", "20.01.2024", "трое суток", "black"},
                {"Селютин", "Ростислав", "Вашингтон", "Сокольники", "42121234569", "17.01.2024", "сутки", "grey"},
        });
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void OrderScooterForTopButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();
        mainPage.clickOrderTopBotton();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.fillingCustomerForm(firstName, lastName, orderAddress, metroStation, customerPhone);

        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillingAboutRentForm(deliveryDate, periodInput, scooterColor, "Привет");

        PopUpAcceptOrderPage popUpAcceptOrderPage = new PopUpAcceptOrderPage(driver);
        popUpAcceptOrderPage.actionButton("Да");

        PopUpOrderIsProcessed popUpOrderIsProcessed = new PopUpOrderIsProcessed(driver);
        popUpOrderIsProcessed.checkOrderStatus();
    }

    @Test
    public void OrderScooterForBottomButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookies();
        mainPage.clickOrderBottomBotton();

        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.fillingCustomerForm(firstName, lastName, orderAddress, metroStation, customerPhone);

        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        aboutRentPage.fillingAboutRentForm(deliveryDate, periodInput, scooterColor, "Привет");

        PopUpAcceptOrderPage popUpAcceptOrderPage = new PopUpAcceptOrderPage(driver);
        popUpAcceptOrderPage.actionButton("Да");

        PopUpOrderIsProcessed popUpOrderIsProcessed = new PopUpOrderIsProcessed(driver);
        popUpOrderIsProcessed.checkOrderStatus();
    }
}