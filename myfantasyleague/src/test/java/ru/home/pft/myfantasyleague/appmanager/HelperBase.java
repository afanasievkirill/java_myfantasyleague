package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelperBase {
  protected WebDriver wd;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if(text != null) {
      String existingText =  wd.findElement(locator).getAttribute("value");
      if(!text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public String closeAlertAndGetItsText() {
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


  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try{
      wd.findElement(locator);
      return true;
    }catch (NoSuchElementException ex) {
      return false;
    }
  }

  public int getHour() {
    DateFormat dateFormat = new SimpleDateFormat("HH");
    Date date = new Date();
    return Integer.parseInt(dateFormat.format(date));
  }

  public int getDayOfWeek() {
    Calendar c = Calendar.getInstance();
    return c.get(Calendar.DAY_OF_WEEK);
  }

}
