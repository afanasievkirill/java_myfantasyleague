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
  private SessionHelper sessionHelper;
  private FranchiseHelper franchiseHelper;
  private WaiverHelper waiverHelper;
  private LineupHelper lineupHelper;
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
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    franchiseHelper = new FranchiseHelper(wd);
    waiverHelper = new WaiverHelper(wd);
    lineupHelper = new LineupHelper(wd);
    sessionHelper.login("Supirpuper", "Fr@nchise43");
  }

  public void stop() {
    wd.findElement(By.xpath("//img[@title='Login']")).click();
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public FranchiseHelper getFranchiseHelper() {
    return franchiseHelper;
  }

  public WaiverHelper getWaiverHelper() {
    return waiverHelper;
  }

  public LineupHelper getLineupHelper() {
    return lineupHelper;
  }
}
