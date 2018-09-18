package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.home.pft.myfantasyleague.model.InformationData;

public class FranchiseInformationHelper {
  private FirefoxDriver wd;

  public FranchiseInformationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void SubmitFranchiseInformation() {
    wd.findElement(By.xpath("//input[@value='Save Franchise Information']")).click();
  }

  public void FillFranchiseInformationForm(InformationData informationData) {
    wd.findElement(By.name("FRANCHISE_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_NAME0043")).sendKeys(informationData.getFranchisename());
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).sendKeys(informationData.getOwnername());
  }
}
