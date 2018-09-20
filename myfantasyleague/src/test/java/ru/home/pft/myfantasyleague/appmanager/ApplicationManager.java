package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;
  private NavigationHelper navigationHelper;
  private BaseInformationHelper baseInformationHelper;
  private SessionHelper sessionHelper;
  private ContactInformationHelper contactInformationHelper;
  private CustomizeInformationHelper customizeInformationHelper;

  public void init() {
    String browser = BrowserType.FIREFOX;
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
