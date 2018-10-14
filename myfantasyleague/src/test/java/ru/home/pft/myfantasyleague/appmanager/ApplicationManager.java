package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;

  private NavigationHelper navigationHelper;
  private SessionHelper sessionHelper;
  private FranchiseHelper franchiseHelper;
  private WaiverHelper waiverHelper;
  private LineupHelper lineupHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    if (browser == BrowserType.FIREFOX) {
      wd = new FirefoxDriver();
    } else if (browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else if (browser == BrowserType.IE) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    franchiseHelper = new FranchiseHelper(wd);
    waiverHelper = new WaiverHelper(wd);
    lineupHelper = new LineupHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"),properties.getProperty("web.adminPassword"));
  }

  public void stop() {
    wd.quit();
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public FranchiseHelper franchise() {
    return franchiseHelper;
  }

  public WaiverHelper waiver() {
    return waiverHelper;
  }

  public LineupHelper lineup() {
    return lineupHelper;
  }
}
