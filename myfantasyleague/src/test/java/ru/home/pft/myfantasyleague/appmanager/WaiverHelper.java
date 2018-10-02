package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.home.pft.myfantasyleague.model.WaiverData;

public class WaiverHelper extends HelperBase {

  public WaiverHelper(WebDriver wd) {
    super(wd);
  }

  public void fillWaiverData(WaiverData waiverData) {
    click(By.xpath(waiverData.getPlayer()));
    type(By.name("BBID_AMT"), waiverData.getBbid());
    type(By.name("COMMENTS"), waiverData.getComment()); // метод добавляет запрос на добавление игрока в период вейвера
  }

  public void fillFreeAgentData(WaiverData waiverData){
    click(By.xpath(waiverData.getPlayer()));
    wd.findElement(By.id("add_drop_submit")).click(); //метод добавляет в состав игрока в период свободных агентов
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

  public void selectTeam() {
    wd.findElement(By.id("add_filt_nfl")).click();
    new Select(wd.findElement(By.xpath("//select[@id='add_filt_nfl']"))).selectByVisibleText("DAL");
    wd.findElement(By.id("add_filt_nfl")).click();
  }

  public boolean isTherWaiver(){
    return isElementPresent(By.linkText("amount_0"));
  }
}
