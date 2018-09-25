package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AddWaiverRequest extends TestBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testAddPlayer() throws Exception {
    app.getNavigationHelper().goToWaiver();
    fillWaiverData("DAL", "TE", "//tr[@id='add_176']/td", "1", "Тест");
    app.getNavigationHelper().submitWaiverRequest();
  }



  private void fillWaiverData(String team, String position, String player, String bbid, String comment) {
    wd.findElement(By.id("add_filt_nfl")).click();
    new Select(wd.findElement(By.id("add_filt_nfl"))).selectByVisibleText(team);
    wd.findElement(By.id("add_filt_pos")).click();
    new Select(wd.findElement(By.id("add_filt_pos"))).selectByVisibleText(position);
    wd.findElement(By.xpath(player)).click();
    wd.findElement(By.name("BBID_AMT")).clear();
    wd.findElement(By.name("BBID_AMT")).sendKeys(bbid);
    wd.findElement(By.name("COMMENTS")).click();
    wd.findElement(By.name("COMMENTS")).clear();
    wd.findElement(By.name("COMMENTS")).sendKeys(comment);
  }

}
