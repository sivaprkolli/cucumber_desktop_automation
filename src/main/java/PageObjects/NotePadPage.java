package PageObjects;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePadPage {
    private WindowsDriver windowsDriver;
    public NotePadPage(WindowsDriver windowsDriver) {
        this.windowsDriver = windowsDriver;
        PageFactory.initElements(windowsDriver, this);
    }

    @FindBy(name = "Add New Tab")
    private WebElement newTabButton;

    @FindBy(name = "Close Tab")
    private WebElement closeTabButton;


    public void sampleTest(){
        newTabButton.click();
        closeTabButton.click();

        windowsDriver.findElementByName("File").click();
        windowsDriver.findElementByName("New tab").click();
        windowsDriver.findElementByName("Text editor").sendKeys("Hello Windows App");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        windowsDriver.findElementByName("Text editor").clear();
    }

}
