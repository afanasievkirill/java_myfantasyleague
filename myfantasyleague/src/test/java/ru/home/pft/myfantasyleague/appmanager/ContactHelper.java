package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.home.pft.myfantasyleague.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
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

}
