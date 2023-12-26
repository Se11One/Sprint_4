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
    public void ImportantQuestionTests() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage MainPage = new MainPage(driver);
        MainPage.AcceptCookies();
        MainPage.CheckOneQuestion();
        MainPage.CheckTwoQuestion();
        MainPage.CheckThreeQuestion();
        MainPage.CheckFourQuestion();
        MainPage.CheckFiveQuestion();
        MainPage.CheckSixQuestion();
        MainPage.CheckSevenQuestion();
        MainPage.CheckEightQuestion();

        MainPage.ClickOrderBottomBotton();
    }


    /*@After
    public void tearDown() {
        // Закрытие браузера после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }*/

}
