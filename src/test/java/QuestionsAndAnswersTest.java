import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.qa_scooter.MainPage;

public class QuestionsAndAnswersTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //Используем менеджер для простой и удобной подготовки драйверов
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void loginTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage MainPage = new MainPage(driver);
        MainPage.AcceptCookies();
        MainPage.CheckResponse();

    }


    /*@After
    public void tearDown() {
        // Закрытие браузера после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }*/

}
