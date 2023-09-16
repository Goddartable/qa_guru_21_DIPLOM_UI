package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static guru.qa.utils.UserVariables.*;

public class RshbDigitalUITest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("remote")
    @Owner("Goddartable")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка работоспособности главной страницы")
    void checkRshbDigitalMain() {
        registrationPage
                .openPage(baseUrl)
                .checkText(indexElement, rsDigital);
    }

    @Test
    @Tag("remote")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка поиска города во вкладке \"Нанимаем\"")
    void checkRshbDigitalVacancy() {
        registrationPage
                .openPage(baseUrl)
                .clickMenuLink(rowGap, hireButton)
                .searchInput(citySearch)
                .checkText(vacancyHeader, citySearch);
    }

    @Test
    @Tag("remote")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка работоспособности страницы \"Интех\"")
    void checkRshbIntech() {
        registrationPage
                .openPage(baseUrl + "/rshb-intech")
                .checkText(mainElement, digitalHeart);
    }

    @Test
    @Tag("remote")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск текста \"Генеральная лицензия Банка России № 3349 от 12 августа 2015\"")
    void checkRshbLicense() {
        registrationPage
                .openPage(baseUrl)
                .checkText(mainElement, genLicense);
    }

    @Test
    @Tag("remote")
    @Owner("Goddartable")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка работоспособности страницы \"О Нас\"")
    void checkRshbAboutUs() {
        registrationPage
                .openPage(baseUrl)
                .clickOnButton(menuBtn)
                .clickMenuLink(indexPage, aboutUs)
                .clickMenuLink(indexPage, aboutPlatform)
                .checkText(mainElement, rsDigital);

    }
}
