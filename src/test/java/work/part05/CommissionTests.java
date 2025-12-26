package work.part05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CommissionTests {

    @ParameterizedTest
    @CsvFileSource(resources = "com_test.csv", numLinesToSkip=1)
    void test02Positive(String username, String password) {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("loginbotton").click();




    }

}
