package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FeeCalculationTests {
    @Test
    public void test01() {
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).type("100");
        $(By.name("submit")).click();
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).setValue("2000");
        $(By.name("submit")).click();
        open("https://slqa.ru/cases/fc/v01/");
        $(By.name("sum")).sendKeys("50000");
        $(By.name("submit")).click();
    }
}