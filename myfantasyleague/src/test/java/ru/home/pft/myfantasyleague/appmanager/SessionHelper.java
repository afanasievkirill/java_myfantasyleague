package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper {
  private FirefoxDriver wd;

  public SessionHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void login(String username, String password) {
    wd.findElement(By.linkText("log into")).click();
    wd.findElement(By.name("USERNAME")).click();
    wd.findElement(By.name("USERNAME")).clear();
    wd.findElement(By.name("USERNAME")).sendKeys(username);
    wd.findElement(By.name("PASSWORD")).clear();
    wd.findElement(By.name("PASSWORD")).sendKeys(password);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hint:'])[3]/following::input[1]")).click();
  }

}
