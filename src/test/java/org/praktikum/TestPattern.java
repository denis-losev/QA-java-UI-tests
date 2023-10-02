package org.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.praktikum.api.Constants;
import org.praktikum.api.User;

public class TestPattern extends Constants {
    protected WebDriver webdriver;
    protected User user;
    public static WebDriver getWebDriver(String browser){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        switch (browser){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/java/org/praktikum/web_driver/chromedriver");
                return new ChromeDriver(options);
            case "Yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/java/org/praktikum/web_driver/yandexdriver");
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Error: WebDriver not found");
        }
    }
    @Before
    public void startWebDriver() {
        webdriver = getWebDriver("Chrome");
    }

    @After
    public void closeWebDriver() {
        webdriver.quit();
    }
}
