package kz.ableacademy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class WorkShopTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome"; // Установка браузера, который будет использоваться для тестирования
    }

    @Test
    public void testCreateAccountWithValidData() {
        open("https://magento.softwaretestingboard.com/customer/account/create/");
        // дописать код здесь
    }


}
