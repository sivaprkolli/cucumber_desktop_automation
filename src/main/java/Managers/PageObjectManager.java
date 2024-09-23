package Managers;

import PageObjects.*;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class PageObjectManager {
    private final WindowsDriver<RemoteWebElement> windowsDriver;
    private NotePadPage notePadPage;
    public PageObjectManager(WindowsDriver windowsDriver) {
        this.windowsDriver = windowsDriver;
    }

    public NotePadPage getLoginPage() {

        if (notePadPage == null) {
            notePadPage = new NotePadPage(windowsDriver);
        }
        return notePadPage;
    }
}
