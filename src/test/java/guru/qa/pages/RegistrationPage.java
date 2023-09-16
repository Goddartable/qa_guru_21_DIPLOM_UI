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
    public RegistrationPage checkText(String selector, String textElement) {
        $(selector).shouldHave(Condition.text(textElement));
        return this;
    }
    @Step("Выбираем пункт меню \"{value}\"")
    public RegistrationPage clickMenuLink(String selector, String menuText) {
        $(selector).$(byText(menuText)).click();
        return this;
    }
    @Step("Начинаем поиск значения \"{value}\"")
    public RegistrationPage searchInput(String textValue) {
        $("div .vacancies__search-city").click();
        $("div .vacancies__search-items").$(byText(textValue)).click();
        $(byText("Найти")).click();
        return this;
    }
    @Step("Нажимаем на кнопку")
    public RegistrationPage clickOnButton(String button) {
        $(button).click();
        return this;
    }

}