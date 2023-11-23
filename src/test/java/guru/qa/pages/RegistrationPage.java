package guru.qa.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    @Step("Открываем страницу")
    public RegistrationPage openPage(String pageLink) {
        open(pageLink);
        return this;
    }

    @Step("Проверяем наличие текста \"{textElement}\"")
    public RegistrationPage checkIndexElementText(String textElement) {
        $(".index-page").shouldHave(Condition.text(textElement));
        return this;
    }

    @Step("Проверяем наличие текста \"{textElement}\"")
    public RegistrationPage checkVacancyHeaderText(String textElement) {
        $(".card-vacancy__header-info").shouldHave(Condition.text(textElement));
        return this;
    }

    @Step("Проверяем наличие текста \"{textElement}\"")
    public RegistrationPage checkFeedbackWindowText(String textElement) {
        $(".modal__body").shouldHave(Condition.text(textElement));
        return this;
    }

    @Step("Выбираем пункт меню \"{menuText}\"")
    public RegistrationPage clickRowGapLinkTest(String menuText) {
        $(".row-gap").$((menuText)).click();
        return this;
    }

    @Step("Проверяем наличие текста \"{textElement}\"")
    public RegistrationPage checkMainElementText(String textElement) {
        $(".main").shouldHave(Condition.text(textElement));
        return this;
    }

    @Step("Выбираем пункт меню \"{menuText}\"")
    public RegistrationPage clickIndexPageLink(String menuText) {
        $(".index-page__menu").$((menuText)).click();
        return this;
    }

    @Step("Выбираем пункт меню \"{menuText}\"")
    public RegistrationPage clickFeedbackWindowLink(String menuText) {
        $(".modal__body").$((menuText)).click();
        return this;
    }

    @Step("Начинаем поиск значения \"{textValue}\"")
    public RegistrationPage searchInput(String textValue) {
        $(".vacancies__search-city").click();
        $(".vacancies__search-items").$(byText(textValue)).click();
        $(byText("Найти")).click();
        return this;
    }

    @Step("Нажимаем на кнопку Меню")
    public RegistrationPage clickOnMenuButton() {
        $(".menu-btn").click();
        return this;
    }

    @Step("Нажимаем на кнопку")
    public RegistrationPage clickOnfeedbackButton() {
        $(".button--green--empty").click();
        return this;
    }

    @Step("Модальное окно появилось")
    public RegistrationPage feedbackWindowAppears() {
        $(".modal__body").should(Condition.appear);
        return this;
    }
}