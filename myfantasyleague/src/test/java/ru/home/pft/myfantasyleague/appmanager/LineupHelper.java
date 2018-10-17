package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.home.pft.myfantasyleague.model.LineupData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class LineupHelper extends HelperBase {

  public LineupHelper(WebDriver wd) {
    super(wd);
  }

  public boolean isThereDefoltSubmissionForm() {
    return isElementPresent(By.xpath("//input[@value='Use Default Submission Form']"));
  }

  public boolean isThereCustomSubmissionForm() {
    return isElementPresent(By.xpath("//input[@value='Use Custom Submission Form']"));
  }

  public void delete () throws InterruptedException {
    if(isThereCustomSubmissionForm()){
      click(By.xpath("//input[@value='Use Custom Submission Form']"));
    }
    click(By.xpath("(//span[@id='clear-starters']/i)[2]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='bench'])[2]/following::i[1]"));
    click(By.id("submit-lineup-form"));
    assertTrue(closeAlertAndGetItsText()
            .matches("^You are now un-submitting \\(clearing out\\) all lineups displayed on this page\\.\nAre you sure that is what you want to do[\\s\\S]$"));
    Thread.sleep(5000);
  }

  public void clean() throws InterruptedException {
    delete();
    click(By.xpath("//input[@value='Use Default Submission Form']"));
    Thread.sleep(1000);
    click(By.xpath("//a[contains(text(),'Go Back To Previous Page')]"));
    Thread.sleep(1000);
  }

  public void goToDefaultSubmissionForm() {
    click(By.xpath("//input[@value='Use Default Submission Form']"));
  }

  public void submit(){
    click(By.id("submit-lineup-form"));
  }

  public List<LineupData> getLineuplist() {
    List<LineupData> lineups = new ArrayList<LineupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("td.player"));
    for (WebElement element : elements) {
      String player = element.getText();
      LineupData lineup = new LineupData().withPlayer(player);
      lineups.add(lineup);
    }
    return lineups;
  }

  public List<LineupData> getProjectList() {
    List<LineupData> projectss = new ArrayList<LineupData>();
    List<WebElement> projects = wd.findElements(By.cssSelector("td.points proj-pts"));
    for (WebElement project : projects) {
      String pp = project.getText();
      int projectPoint = Integer.parseInt(pp);
      LineupData lineup = new LineupData().withProjectPoint(projectPoint);
      projectss.add(lineup);
    }
    return projectss;
  }

  public void selectPlayer(String player) {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" + player + "])[1]/preceding::input[1]"));
  }

  public void fiilLineup(LineupData lineup) {
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getQb()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getRb1()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getRb2()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getWr1()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getWr2()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getWr3()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getTe()+"'])[1]/preceding::input[1]"));
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+lineup.getSflex()+"'])[1]/preceding::input[1]"));
  }

  public boolean itsLineupTime() {
    int dayOfWeek = getDayOfWeek();
    int hour = getHour();
    if (dayOfWeek >= 2 && hour >= 9  || dayOfWeek <= 6 && hour <= 20) {
      System.out.println("Время выставить лайнап");
      return true;
    } else {
      System.out.println("Лайнап должен был быть выставлен");
      return false;
    }
  }
}
