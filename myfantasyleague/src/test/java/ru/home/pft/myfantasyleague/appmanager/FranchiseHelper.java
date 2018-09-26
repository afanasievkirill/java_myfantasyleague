package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.home.pft.myfantasyleague.model.ContactData;
import ru.home.pft.myfantasyleague.model.CustomizeData;
import ru.home.pft.myfantasyleague.model.InformationData;

public class FranchiseHelper extends HelperBase {

  public FranchiseHelper(WebDriver wd) {
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

  public void fillContactInformation(ContactData contactData) {
    type(By.name("FRANCHISE_DAY_PHONE0043"), contactData.getDayphone());
    type(By.name("FRANCHISE_EVENING_PHONE0043"), contactData.getHomephone());
    type(By.name("FRANCHISE_ADDRESS0043"), contactData.getStreet());
    type(By.name("FRANCHISE_CITY0043"), contactData.getCity());
    type(By.name("FRANCHISE_ZIP0043"), contactData.getZip());
    type(By.name("TWITTER_USERNAME0043"), contactData.getTwitter());
  }

  public void flagUp(String locator) {
    click(By.id(locator));
  }

  public void fillBaseInformationForm(InformationData informationData) {
    type(By.name("FRANCHISE_NAME0043"), informationData.getFranchisename());
    type(By.name("FRANCHISE_OWNER_NAME0043"), informationData.getOwnername());
  }
}
