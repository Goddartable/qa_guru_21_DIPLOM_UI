package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;

public class RshbDigitalUITest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("Intech")
    @Owner("Goddartable")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка работоспособности https://rshbdigital.ru/")
    void checkRshbDigitalMain() {
        registrationPage
                .openPage(baseUrl)
                .checkText(".index-page", "РСХБ в цифре — продукт объединённой команды Россельхозбанка и РСХБ-Интеха.");
    }

    @Test
    @Tag("Intech")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка поиска города во вкладке \"Нанимаем\"")
    void checkRshbDigitalVacancy() {
        registrationPage
                .openPage(baseUrl)
                .clickMenuLink("div .row-gap", "Нанимаем")
                .searchInput("Тверь")
                .checkText("div .card-vacancy__header-info", "Тверь");
    }

    @Test
    @Tag("Intech")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка Интех")
    void checkRshbIntech() {
        registrationPage
                .openPage("https://rshb-intech.ru/rshb-intech")
                .checkText(".main", "Диджитал-сердце Россельхозбанка. Мы занимаемся цифровой трансформацией крупнейшего сельскохозяйственного банка России.");
    }

    @Test
    @Tag("Intech")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск \"Генеральная лицензия Банка России № 3349 от 12 августа 2015\"")
    void checkRshbLicense() {
        registrationPage
                .openPage(baseUrl)
                .checkText(".main", "Генеральная лицензия Банка России № 3349 от 12 августа 2015");
    }

    @Test
    @Tag("Intech")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск \"О-Нас\"")
    void checkRshbAboutUs() {
        registrationPage
                .openPage(baseUrl)
                .clickOnButton(".menu-btn")
                .clickMenuLink("a[class=nav-link]", "О Нас");
     //           .clickMenuLink("div .menu-btn", "О платформе");
    }
}
