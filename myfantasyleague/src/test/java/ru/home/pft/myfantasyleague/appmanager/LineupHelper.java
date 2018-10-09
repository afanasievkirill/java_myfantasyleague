package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.home.pft.myfantasyleague.model.LineupData;

import java.util.ArrayList;
import java.util.List;

public class LineupHelper extends HelperBase {

  public LineupHelper(WebDriver wd) {
    super(wd);
  }

  public boolean isThereDefoltSubmissionForm() {
    return isElementPresent(By.xpath("//input[@value='Use Default Submission Form']"));
  }

  public void goToDefaultSubmissionForm() {
    click(By.xpath("//input[@value='Use Default Submission Form']"));
  }

  public List<LineupData> getLineuplist() {
    List<LineupData> lineups = new ArrayList<LineupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("td.player"));

    for (WebElement element : elements) {
      String player = element.getText();
      LineupData lineup = new LineupData(player, 0);
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
      LineupData lineup = new LineupData(null, projectPoint);
      projectss.add(lineup);
    }
    return projectss;
  }

  public void SelectPlayer(String player) {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" + player + "])[1]/preceding::input[1]")).click();
  }
}