package work.part02;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class NavigationTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
    }
    @Test
    void testNavigation() {
        open("https://ya.ru/");
        sleep(5_000);
        open("https://yandex.ru/pogoda/");
        sleep(3_000);
        open("https://yandex.ru/pogoda/ru/saint-petersburg");
        sleep(3_000);
        back();
        sleep(3_000);
        back();
        sleep(3_000);
        forward();
        sleep(5_000);
    }
}