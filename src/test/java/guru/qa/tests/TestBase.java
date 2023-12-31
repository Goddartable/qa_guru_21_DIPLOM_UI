package guru.qa.tests;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.attachments.ReportAttachments;
import guru.qa.config.ConfigReader;
import guru.qa.config.WebConfig;
import guru.qa.config.WebConfigProject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import io.qameta.allure.selenide.AllureSelenide;


public class TestBase {
    private static final WebConfig config = ConfigReader.Instance.read();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        WebConfigProject webConfigForProject = new WebConfigProject(config);
        webConfigForProject.webConfig();
    }

    @AfterEach
    void afterEachTest() {
        ReportAttachments.addVideo();
        ReportAttachments.attachScreenshot();
        ReportAttachments.pageSource();
        ReportAttachments.browserConsoleLogs();
        Selenide.closeWebDriver();
    }
}
