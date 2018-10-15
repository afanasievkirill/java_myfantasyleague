package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.home.pft.myfantasyleague.model.ContactData;
import ru.home.pft.myfantasyleague.model.PlayerData;
import ru.home.pft.myfantasyleague.model.Players;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WaiverHelper extends HelperBase {

  public WaiverHelper(WebDriver wd) {
    super(wd);
  }

  public void fillRequest(PlayerData playerData) {
    click(By.xpath(playerData.getPlayerID()));
    type(By.name("BBID_AMT"), playerData.getBbid());
    type(By.name("COMMENTS"), playerData.getComment());

  }

  public void fillFreeAgentData(PlayerData playerData) {
    click(By.xpath(playerData.getPlayerID()));
    click(By.id("add_drop_submit")); //метод добавляет в состав игрока в период свободных агентов
  }

  public void deletePlayer() {
    click(By.linkText("Delete"));
  }

  public void editWaiver() {
    click(By.linkText("Edit"));
  }

  public void submit() {
    click(By.id("add_drop_submit"));
  }

  public void saveWaiverEdit() {
    click(By.name("SAVE"));
  }

  public void editFillWaiver(PlayerData playerData) {
    editWaiver();
    type(By.id("amount_0"), playerData.getBbid());
    type(By.id("comment"), playerData.getComment());
    saveWaiverEdit();
  }

  public void cansel(){
    click(By.name("CANCEL"));
  }

  public void addRequest(PlayerData requestData) {
    fillRequest(requestData);
    submit();
  }

  public boolean isThereRequest() {
    return isElementPresent(By.linkText("Edit"));
  }

  public void selectTeam() {
    click(By.id("add_filt_nfl"));
    new Select(wd.findElement(By.xpath("//select[@id='add_filt_nfl']"))).selectByVisibleText("DAL");
    click(By.id("add_filt_nfl"));
  }

  public void dpopPlayer(PlayerData playerData) {
    click(By.xpath(playerData.getPlayerID()));
  }

  public int getPlayerCount() {
    return wd.findElements(By.cssSelector("*[id^='drop_']")).size();
  }

  private Players dropPlayers = null;

  public Players all() {
    dropPlayers = new Players();
    List<WebElement> rows = wd.findElements(By.cssSelector("*[id^='drop_']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      String player = cells.get(0).getText();
      dropPlayers.add(new PlayerData().withPlayer(player));
    }
    return new Players(dropPlayers);
  }

  public boolean itsWaiver() {
    int dayOfWeek = getDayOfWeek();
    int hour = getHour();
    if (dayOfWeek == 4 && hour >= 12 || dayOfWeek == 5 || dayOfWeek == 6 && hour <= 8) {
      System.out.println("Не вэйвер");
      return false;
    } else {
      System.out.println("Вейвер");
      return true;
    }
  }

}
