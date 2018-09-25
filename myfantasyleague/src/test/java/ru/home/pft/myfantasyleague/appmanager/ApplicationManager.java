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
  private BaseHelper baseHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private CustomizeHelper customizeHelper;
  private WaiverHelper waiverHelper;
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
    baseHelper = new BaseHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    customizeHelper = new CustomizeHelper(wd);
    waiverHelper = new WaiverHelper(wd);
    sessionHelper.login("Supirpuper", "Fr@nchise43");
  }

  public void stop() {
    wd.findElement(By.xpath("//img[@title='Login']")).click();
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  public BaseHelper getBaseHelper() {
    return baseHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public CustomizeHelper getCustomizeHelper() {
    return customizeHelper;
  }

  public WaiverHelper getWaiverHelper() {
    return waiverHelper;
  }
}
