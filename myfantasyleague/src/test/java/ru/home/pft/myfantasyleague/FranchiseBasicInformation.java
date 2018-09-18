package ru.home.pft.myfantasyleague;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FranchiseBasicInformation {
  private FirefoxDriver wd;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://www62.myfantasyleague.com/2018/home/74575");
    wd.findElement(By.linkText("log into")).click();
    wd.findElement(By.name("USERNAME")).click();
    wd.findElement(By.name("USERNAME")).clear();
    wd.findElement(By.name("USERNAME")).sendKeys("Supirpuper");
    wd.findElement(By.name("PASSWORD")).clear();
    wd.findElement(By.name("PASSWORD")).sendKeys("Fr@nchise43");
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hint:'])[3]/following::input[1]")).click();
  }

  @Test
  public void testFranchiseBasicInformation() throws Exception {

    wd.findElement(By.linkText("franchise information")).click();
    wd.findElement(By.name("FRANCHISE_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_NAME0043")).sendKeys("Supir Mario Bros");
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).sendKeys("SupirPuper");
    wd.findElement(By.xpath("//input[@value='Save Franchise Information']")).click();
    wd.findElement(By.xpath("//img[@title='Login']")).click();
    wd.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }


}
