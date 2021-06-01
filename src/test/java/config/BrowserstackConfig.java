package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("bs.api.url")
    String bsApiUrl();
    @Key("bs.hub.url")
    String bsHubUrl();
    @Key("bs.username")
    String bsUsername();
    @Key("bs.password")
    String bsPassword();
    @Key("bs.app")
    String bsApp();
    @Key("bs.project")
    String bsProject();
    @Key("bs.build")
    String bsBuild();
    @Key("bs.name")
    String bsName();
}
