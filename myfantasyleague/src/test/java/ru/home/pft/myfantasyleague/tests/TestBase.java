package ru.home.pft.myfantasyleague.tests;

import com.sun.deploy.uitoolkit.impl.text.TextConsoleWindow;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.home.pft.myfantasyleague.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);
  protected final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  public String testPlayer = "//tr[@id='add_539']/td";

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @BeforeMethod()
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + "with parameters " + Arrays.asList(p));
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p) {
    logger.info("Stop test " + m.getName() + "with parameters " + Arrays.asList(p));
  }

  public ApplicationManager getApp() {
    return app;
  }
}
