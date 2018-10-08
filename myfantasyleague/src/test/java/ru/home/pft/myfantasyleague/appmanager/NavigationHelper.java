package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void information() {
    click(By.linkText("franchise information"));
  }

  public void informationTD() {
    click(By.xpath("//a[contains(text(),'Franchise Setup')]"));
  }

  public void goToContactInformation() {
    click(By.linkText("contact information"));
  }

  public void goToCustomizeInformation() {
    click(By.linkText("customize"));
  }

    public void goToWaiver() {
    click(By.linkText("Add/Drop Players"));
  }

  public void goToLineup() {
    click(By.xpath("//a[contains(text(),'Submit Lineup')]"));
  }

  public void submit() {
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

  public  void home(){
    //click(By.linkText("League Home"));
    click(By.cssSelector("span.leaguename--the"));
  }

}
