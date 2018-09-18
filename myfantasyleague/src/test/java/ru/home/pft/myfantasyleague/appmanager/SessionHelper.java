package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    click(By.linkText("log into"));
    type(By.name("USERNAME"),username);
    type(By.name("PASSWORD"),password);
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hint:'])[3]/following::input[1]"));
  }

}
