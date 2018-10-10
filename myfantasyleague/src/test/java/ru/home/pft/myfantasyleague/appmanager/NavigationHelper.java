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

  public void Contact() {
    click(By.linkText("contact information"));
  }

  public void contactTD() {
    click(By.xpath("//a[contains(text(),'Franchise Setup')]"));
    click(By.linkText("Contact Info"));
  }

  public void customize() {
    click(By.linkText("customize"));
  }

  public void customizeTD() {
    click(By.xpath("//a[contains(text(),'Franchise Setup')]"));
    click(By.linkText("Customize"));
  }

  public void waiver() {
    click(By.linkText("Add/Drop Players"));
  }

  public void backWaiver() {
    wd.findElement(By.linkText("Go Back To Previous Page")).click();
  }

  public void goToLineup() {
    click(By.xpath("//a[contains(text(),'Submit Lineup')]"));
  }

  public void submit() {
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

  public void home() {
    //click(By.linkText("League Home"));
    click(By.cssSelector("span.leaguename--the"));
  }

  public void back() {
    wd.navigate().back();
  }
}
