package org.fasttrackit;

import org.fasttrackit.AppConfig;
import org.fasttrackit.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver = DriverFactory.getDriver();

    public void openHomepage() {
        driver.get(AppConfig.getSiteURL());
    }
}
