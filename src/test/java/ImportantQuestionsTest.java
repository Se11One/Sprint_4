import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.qa_scooter.MainPage;

public class ImportantQuestionsTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //Используем менеджер для простой и удобной подготовки драйверов
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // Закрытие браузера после завершения теста
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ImportantQuestionTests() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage MainPage = new MainPage(driver);
        MainPage.AcceptCookies();
        MainPage.CheckOneQuestion("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        MainPage.CheckTwoQuestion("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        MainPage.CheckThreeQuestion("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        MainPage.CheckFourQuestion("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        MainPage.CheckFiveQuestion("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        MainPage.CheckSixQuestion("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        MainPage.CheckSevenQuestion("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        MainPage.CheckEightQuestion("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }
}
