package Managers;

import Enums.DriverType;
import Enums.EnvironmentType;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AllDriverManager {

    private WindowsDriver<RemoteWebElement> windowsDriver;
    private static DriverType driverType;
    public static EnvironmentType environmentType;
    public String gridURL = null;

    public AllDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    private WindowsDriver<RemoteWebElement> createLocalDriver() {
        switch (driverType) {
            case WINDOWS:
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
                try {
                    windowsDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), dc);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        long time = FileReaderManager.getInstance().getConfigFileReader().getTime();
        windowsDriver.manage().window().maximize();
        windowsDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

        return windowsDriver;
    }

    private WindowsDriver<RemoteWebElement> createRemoteDriver() {
        WebDriver webDriver = null;
        switch (driverType) {
            case WINDOWS:
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
                try {
                    windowsDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), dc);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }                break;
                    }
        return windowsDriver;
    }

    private WindowsDriver<RemoteWebElement> createDriver() {
        switch (environmentType) {
            case LOCAL:
                windowsDriver = createLocalDriver();
                break;
            case REMOTE:
                windowsDriver = createRemoteDriver();
                break;
        }
        return windowsDriver;
    }

    public WindowsDriver<RemoteWebElement> getDriver() {
        if (windowsDriver == null) windowsDriver = createDriver();
        return windowsDriver;
    }

    public void closeDriver() {
        windowsDriver.quit();
    }
}
