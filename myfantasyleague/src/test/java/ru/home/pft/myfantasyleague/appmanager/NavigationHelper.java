package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void GoToFranchiseInformation() {
    click(By.linkText("franchise information"));
  }

  public void GoToContactInformation() {
    click(By.linkText("contact information"));
  }

  public void SubmitFranchiseInformation(){
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

}
