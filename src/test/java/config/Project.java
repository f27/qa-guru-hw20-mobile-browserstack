package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class);
}
