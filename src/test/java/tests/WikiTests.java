package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {
    @Test
    @DisplayName("Simple search test")
    void simpleWikiSearchTest() {
        step("Open app", () -> {
            open();
        });

        step("If opened onboarding page - press back button", () -> {
            if ($(MobileBy.id("org.wikipedia.alpha:id/view_onboarding_page_indicator")).isDisplayed()) {
                back();
            }
        });

        step("Click on 'Search Wikipedia'", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
        });

        step("Type 'Browserstack'", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Browserstack");
        });

        step("Verify success search", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/search_results_list")).shouldHave(sizeGreaterThan(0));
        });
    }
}
