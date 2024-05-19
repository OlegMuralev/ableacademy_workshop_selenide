package kz.ableacademy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class MagnetoTest {
    private final SelenideElement firstNameField = $("#firstname");
    private final SelenideElement lastNameField = $("#lastname");
    private final SelenideElement emailField = $("#email_address");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement passwordConfirmationField = $("#password-confirmation");
    private final SelenideElement submitButton = $x("//*[@id=\"form-validate\"]/div/div[1]/button");
    private final SelenideElement successMessage = $x("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    private final SelenideElement notSamePasswordMessage = $x("//*[@id=\"password-confirmation-error\"]");
    private final SelenideElement weakPassswordMessage = $x("//*[@id=\"password-error\"]");
    private static final String url = "https://magento.softwaretestingboard.com/customer/account/create/";

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome"; // Установка браузера, который будет использоваться для тестирования
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver(); // Закрытие браузера после каждого теста
    }


    @Test
    public void testCreateAccountWithValidData() {
        open(url);
        firstNameField.setValue(RandomStringGenerator.generateRandomString());
        lastNameField.setValue(RandomStringGenerator.generateRandomString());
        emailField.setValue(RandomStringGenerator.generateRandomString() + "@test.com");
        passwordField.setValue("Abs12345678!");
        passwordConfirmationField.setValue("Abs12345678!");
        submitButton.click();
        successMessage.shouldHave(Condition.text("Thank you for registering with Main Website Store."));
    }

    @Test
    public void testCreateAccountWithNotSamePassword() {
        open("https://magento.softwaretestingboard.com/customer/account/create/");
        firstNameField.setValue(RandomStringGenerator.generateRandomString());
        lastNameField.setValue(RandomStringGenerator.generateRandomString());
        emailField.setValue(RandomStringGenerator.generateRandomString() + "@test.com");
        passwordField.setValue("Abs12345678!");
        passwordConfirmationField.setValue("Abs12345678!!");
        submitButton.click();
        notSamePasswordMessage.shouldHave(Condition.text("Please enter the same value again."));
    }

    @Test
    public void testCreateAccountWithWeakPassword() {
        open("https://magento.softwaretestingboard.com/customer/account/create/");
        passwordField.setValue("11111111");
        passwordConfirmationField.setValue("11111111");
        submitButton.click();
        weakPassswordMessage.shouldHave(Condition.text("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."));
    }
}
