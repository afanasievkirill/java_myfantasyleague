package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void GoToFranchiseInformation() {
    click(By.linkText("franchise information"));
  }
}
