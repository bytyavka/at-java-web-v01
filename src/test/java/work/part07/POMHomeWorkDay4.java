package work.part07;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import work.part07.pages.FlightsListPage;
import work.part07.pages.LoginPage;
import work.part07.pages.SearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Execution(ExecutionMode.CONCURRENT)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMHomeWorkDay4 {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "firefox";
    }

    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        getWebDriver().manage().window().maximize();
        sleep(10_000);
    }

    // 1. Вход с пустыми полями
    @Test
    void test01EmptyLoginData() {
        LoginPage myLoginPage = new LoginPage();
        myLoginPage.login("", "");
        myLoginPage.isLoginUnsuccessful();
    }

    // 2. Вход с корректными данными и отображение ФИО
    @Test
    void test02LogoutButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.logoutExist();
    }

    // 3. Найти рейс
    @Test
    void test03ReturnToSearchPage() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.fidnButtonWork();

        FlightsListPage flightsList = new FlightsListPage();
        flightsList.newSearch();

        searchPage.logoutExist();
    }

    // 4. Прошедшая дата
    @Test
    void test04SearchPastDate() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.SetPastDate();
        searchPage.fidnButtonWork();
        searchPage.isDateInPast();
    }

    // 5. Заблокированный пользователь
    @Test
    void test05BlockedUserHomework() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("locked_out_user", "lock_pass2");
        loginPage.isUserBlocked();
    }
    // 6. Отсутствует дата
    @Test
    void test06LogoutButton() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.search("");
        searchPage.isDepartureDateEmpty();
        searchPage.logoutExist();
    }
}