package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
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

  public void submitFranchiseInformation() {
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

  public void goToWaiver() {
    click(By.linkText("Add/Drop Players"));
  }

}
