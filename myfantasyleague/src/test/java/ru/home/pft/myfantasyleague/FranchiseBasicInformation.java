package ru.home.pft.myfantasyleague;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FranchiseBasicInformation {
  private FirefoxDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFranchiseOption() throws Exception {
    wd.get("http://www62.myfantasyleague.com/2018/home/74575");
    wd.findElement(By.linkText("log into")).click();
    wd.findElement(By.name("USERNAME")).click();
    wd.findElement(By.name("USERNAME")).clear();
    wd.findElement(By.name("USERNAME")).sendKeys("Supirpuper");
    wd.findElement(By.name("PASSWORD")).clear();
    wd.findElement(By.name("PASSWORD")).sendKeys("Fr@nchise43");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hint:'])[3]/following::input[1]")).click();
    wd.findElement(By.linkText("franchise information")).click();
    wd.findElement(By.name("FRANCHISE_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_NAME0043")).sendKeys("Supir Mario Bros");
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).sendKeys("SupirPuper");
    wd.findElement(By.xpath("//input[@value='Save Franchise Information']")).click();
    //wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
