package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToFranchiseInformation() {
    click(By.linkText("franchise information"));
  }

  public void goToContactInformation() {
    click(By.linkText("contact information"));
  }

  public void goToCustomizeInformation() {
    click(By.linkText("customize"));
  }

  public void submitFranchiseInformation(){
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

}
