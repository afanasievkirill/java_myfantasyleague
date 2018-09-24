package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private NavigationHelper navigationHelper;
  private BaseInformationHelper baseInformationHelper;
  private SessionHelper sessionHelper;
  private ContactInformationHelper contactInformationHelper;
  private CustomizeInformationHelper customizeInformationHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    } else if (browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if (browser == BrowserType.IE) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("http://www62.myfantasyleague.com/2018/home/74575");
    baseInformationHelper = new BaseInformationHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactInformationHelper = new ContactInformationHelper(wd);
    customizeInformationHelper = new CustomizeInformationHelper(wd);
    sessionHelper.login("Supirpuper", "Fr@nchise43");
  }

  public void stop() {
    wd.findElement(By.xpath("//img[@title='Login']")).click();
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  public BaseInformationHelper getBaseInformationHelper() {
    return baseInformationHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactInformationHelper getContactInformationHelper() {
    return contactInformationHelper;
  }

  public CustomizeInformationHelper getCustomizeInformationHelper() {
    return customizeInformationHelper;
  }
}
