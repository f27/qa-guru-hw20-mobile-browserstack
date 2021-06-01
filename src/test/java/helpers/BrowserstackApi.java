package helpers;

import config.Project;

import static io.restassured.RestAssured.given;

public class BrowserstackApi {
    public static String getVideoUrl(String sessionId) {
        return given()
                .auth().basic(Project.browserstackConfig.bsUsername(), Project.browserstackConfig.bsPassword())
                .when()
                .get(Project.browserstackConfig.bsApiUrl() + "/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
