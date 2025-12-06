package demo.part01;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SimpleWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
    }

    @Test
    void test01() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("WebDriver"));
    }
    @Test
    void test02() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $("body").shouldHave(text("Selenide"));

        sleep(2000);
    }
    @Test
    void test03() {
        open("https://slqa.ru/cases/SimpleForm/");
        $("body").shouldHave(text("Томас Фуллер"));
    }
}