package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("browserstack.user", Project.browserstackConfig.bsUsername());
        capabilities.setCapability("browserstack.key", Project.browserstackConfig.bsPassword());
        capabilities.setCapability("app", Project.browserstackConfig.bsApp());
        capabilities.setCapability("device", Project.deviceConfig.device());
        capabilities.setCapability("os_version", Project.deviceConfig.osVersion());
        capabilities.setCapability("project", Project.browserstackConfig.bsProject());
        capabilities.setCapability("build", Project.browserstackConfig.bsBuild());
        capabilities.setCapability("name", Project.browserstackConfig.bsName());

        System.out.println(capabilities);


        if ("ios".equals(System.getProperty("os"))) {
            return new IOSDriver(getBrowserstackUrl(), capabilities);
        }
        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    private static URL getBrowserstackUrl() {
        try {
            return new URL(
                    String.format(
                            Project.browserstackConfig.bsHubUrl(),
                            Project.browserstackConfig.bsUsername(),
                            Project.browserstackConfig.bsPassword())
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
