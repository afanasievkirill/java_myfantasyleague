package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;
  private NavigationHelper navigationHelper;
  private FranchiseInformationHelper franchiseInformationHelper;
  private SessionHelper sessionHelper;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://www62.myfantasyleague.com/2018/home/74575");
    franchiseInformationHelper = new FranchiseInformationHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("Supirpuper", "Fr@nchise43");
  }

  public void stop() {
    wd.findElement(By.xpath("//img[@title='Login']")).click();
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }

    public FranchiseInformationHelper getFranchiseInformationHelper() {
    return franchiseInformationHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
