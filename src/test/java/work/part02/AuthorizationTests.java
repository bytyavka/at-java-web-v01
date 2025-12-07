package work.part02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTests {
    @Test
    public void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.id("greeting")).shouldHave(text("Добро пожаловать,"));

    }
    @Test
    public void test02LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("stand_pass1");
        $(By.id("password")).type("standard_user");
        $(By.id("loginButton")).click();
        $(By.id("message")).shouldHave(text("Неверное имя пользователя"));

    }
}