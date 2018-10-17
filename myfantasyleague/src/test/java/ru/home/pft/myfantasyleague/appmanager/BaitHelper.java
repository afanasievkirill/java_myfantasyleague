package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaitHelper extends HelperBase {

  public BaitHelper(WebDriver wd) {
    super(wd);
  }

  public boolean isThereBait(){
    return isElementPresent(By.linkText("Delete"));
  }

  public void delete(){
    click(By.linkText("Delete"));
  }
}
