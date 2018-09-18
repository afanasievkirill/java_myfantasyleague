package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.home.pft.myfantasyleague.model.BasicInformationData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private FirefoxDriver wd;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://www62.myfantasyleague.com/2018/home/74575");
    login("Supirpuper", "Fr@nchise43");
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

  public void SubmitFranchiseInformation() {
    wd.findElement(By.xpath("//input[@value='Save Franchise Information']")).click();
  }

  public void FillFranchiseInformationForm(BasicInformationData basicInformationData) {
    wd.findElement(By.name("FRANCHISE_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_NAME0043")).sendKeys(basicInformationData.getFranchisename());
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).click();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).clear();
    wd.findElement(By.name("FRANCHISE_OWNER_NAME0043")).sendKeys(basicInformationData.getOwnername());
  }

  public void GoToFranchiseInformation() {
    wd.findElement(By.linkText("franchise information")).click();
  }

  public void stop() {
    wd.findElement(By.xpath("//img[@title='Login']")).click();
    wd.findElement(By.linkText("Logout")).click();
    wd.quit();
  }
}
