package guru.qa.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class WebConfigProject {
    private final WebConfig webConfig;

    public WebConfigProject(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser().toString();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.pageLoadStrategy = "eager";

        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            Map<String, Object> value = new HashMap<>();
            value.put("enableVNC", true);
            value.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", value);
            Configuration.browserCapabilities = capabilities;
        }
    }

}