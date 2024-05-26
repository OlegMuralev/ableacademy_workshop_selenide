package kz.ableacademy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class WorkShopTest {
    private final SelenideElement firstname = $("#firstname");
    private final SelenideElement lastname = $("#lastname");
    private final SelenideElement email = $("#email_address");
    private final SelenideElement password = $("#password");
    private final SelenideElement confirmPassword = $("#password-confirmation");
    private final SelenideElement notificationSuccess = $x("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    private final SelenideElement submitButton = $x("//*[@id=\"form-validate\"]/div/div[1]/button/span");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome"; // Установка браузера, который будет использоваться для тестирования
    }

    @Test
    public void testFormValidData() {
        open("https://magento.softwaretestingboard.com/customer/account/create/");
        firstname.setValue("Micle");
        lastname.setValue("Jackson");
        email.setValue(RandomStringGenerator.generateRandomString() + "@mail.com");
        password.setValue("Abs12345678!");
        confirmPassword.setValue("Abs12345678!");
        submitButton.click();

        // ожидаемый результат
        notificationSuccess.shouldHave(Condition.text("Thank you for registering with Main Website Store."));
    }

    @Test
    public void testPasswordSevenSymbols(){
        open("https://magento.softwaretestingboard.com/customer/account/create/");
        password.setValue("Abs1234");
        // ожидаемый результат
        $("#password-error").shouldHave(Condition.text("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."));
    }
/*
Тест-кейс 2 - Заполнить форму паролем 7 символов
Шаги:
1) Перейти на страницу https://magento.softwaretestingboard.com/customer/account/create/
2) Заполнить поле Password - Abs1234
Ожидаемый результат:
Появилось сообщение - "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."

| Элемент                    | Локатор                                         |
| -------------------------- | ----------------------------------------------- |
| Сообщение об ошибке        | #password-error                                      |
*/
}
