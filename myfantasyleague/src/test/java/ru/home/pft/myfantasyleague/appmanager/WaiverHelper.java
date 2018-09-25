package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.home.pft.myfantasyleague.model.WaiverData;

public class WaiverHelper extends HelperBase {

  public WaiverHelper(WebDriver wd) {
    super(wd);
  }

  public void fillWaiverData(WaiverData waiverData) {
    click(By.xpath(waiverData.getPlayer()));
    type(By.name("BBID_AMT"), waiverData.getBbid());
    type(By.name("COMMENTS"), waiverData.getComment());
  }

  public void deletePlayer() {
    click(By.linkText("Delete"));
  }

  public void editWaiver() {
    click(By.linkText("Edit"));
  }

  public void submitWaiverRequest() {
    wd.findElement(By.id("add_drop_submit")).click();
  }

  public void saveWaiverEdit() {
    wd.findElement(By.name("SAVE")).click();
  }

  public void editFillWaiver(String BBID, String comment) {
    type(By.id("amount_0"), BBID);
    type(By.id("comment"), comment);
  }


  public void addRequest(WaiverData requestData) {
    fillWaiverData(requestData);
    submitWaiverRequest();
  }

  public boolean isThereRequest() {
    return isElementPresent(By.linkText("Edit"));
  }
}
