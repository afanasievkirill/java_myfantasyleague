package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.home.pft.myfantasyleague.model.CustomizeData;

public class CustomizeInformationHelper extends HelperBase {

  public CustomizeInformationHelper(WebDriver wd) {
    super(wd);
  }

  public void fillCustomizeInformation(CustomizeData customizeData) {
    type(By.name("FRANCHISE_ABBREV0043"), customizeData.getAbbriveation());
    type(By.name("FRANCHISE_STADIUM0043"), customizeData.getStadium() );
    type(By.id("NOTES0043"), customizeData.getNote());
  }

  public void fillTimeZone(String timezone) {
    click(By.name("TIME_ZONE0043"));
    new Select(wd.findElement(By.name("TIME_ZONE0043"))).selectByVisibleText(timezone);
  }
}
