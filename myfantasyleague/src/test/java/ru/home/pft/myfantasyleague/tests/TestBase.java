package ru.home.pft.myfantasyleague.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.home.pft.myfantasyleague.appmanager.ApplicationManager;


public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  public String testPlayer = "//tr[@id='add_539']/td";

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
