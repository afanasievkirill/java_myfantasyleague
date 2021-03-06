package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.home.pft.myfantasyleague.model.ContactData;
import ru.home.pft.myfantasyleague.model.CustomizeData;
import ru.home.pft.myfantasyleague.model.InformationData;

public class FranchiseHelper extends HelperBase {

  public FranchiseHelper(WebDriver wd) {
    super(wd);
  }

  public void customize(CustomizeData customizeData) {
    type(By.name("FRANCHISE_ABBREV0043"), customizeData.getAbbriveation());
    type(By.name("FRANCHISE_STADIUM0043"), customizeData.getStadium());
    type(By.id("NOTES0043"), customizeData.getNote());
    attach(By.name("FRANCHISE_ICON_FILE0043"), customizeData.getFranchiseIcon());
    click(By.name("TIME_ZONE0043"));
    new Select(wd.findElement(By.name("TIME_ZONE0043"))).selectByVisibleText(customizeData.getTimezone());
    submit();
  }

  public CustomizeData infoFromeFranchiseHomeForm(CustomizeData customize) {
    click(By.linkText("Franchise Home"));
    String stadium = wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Stadium:'])[1]/following::td[1]")).getText();
    String note = wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Other Franchise Notes:'])[1]/following::td[1]")).getText();

    return new CustomizeData().withStadium(stadium).withNote(note);
  }

  public void fillTimeZone(String timezone) {
    click(By.name("TIME_ZONE0043"));
    new Select(wd.findElement(By.name("TIME_ZONE0043"))).selectByVisibleText(timezone);
  }

  public void fillContact(ContactData contactData, String locator) {
    type(By.name("FRANCHISE_DAY_PHONE0043"), contactData.getDayphone());
    type(By.name("FRANCHISE_EVENING_PHONE0043"), contactData.getHomephone());
    type(By.name("FRANCHISE_ADDRESS0043"), contactData.getStreet());
    type(By.name("FRANCHISE_CITY0043"), contactData.getCity());
    select(By.name("FRANCHISE_STATE0043"), contactData.getState());
    type(By.name("FRANCHISE_ZIP0043"), contactData.getZip());
    type(By.name("TWITTER_USERNAME0043"), contactData.getTwitter());
    click(By.id(locator));
    submit();
  }

  public ContactData contactFromFranchiseHome(ContactData contact) {
    click(By.linkText("Franchise Home"));
    String dayphone = wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Daytime Phone:'])[1]/following::td[1]")).getText();
    String homephone = wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Evening Phone:'])[1]/following::td[1]")).getText();
    String address = wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Address:'])[1]/following::td[1]")).getText();
    String twitter = wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Twitter:'])[1]/following::td[1]")).getText();
    return new ContactData().withDayphone(dayphone).withHomephone(homephone).withAddress(address).withTwitter(twitter);
  }

  public void flagUp(String locator) {
    click(By.id(locator));
  }

  public void fillForm(InformationData informationData) {
    type(By.name("FRANCHISE_NAME0043"), informationData.getFranchisename());
    type(By.name("FRANCHISE_OWNER_NAME0043"), informationData.getOwnername());
    submit();
  }


  public InformationData infoFromeHomeForm(InformationData information) {
    String franchisename = wd.findElement(By.xpath("//table[@id='roster']/caption/span[2]/a")).getText();
    click(By.xpath("//table[@id='roster']/caption/span/a"));
    String ownername = wd.findElement(By.xpath("//table[@id='single_roster']/tbody/tr/td/div/table/caption/span/span")).getText();
    return new InformationData().withFranchisename(franchisename).withOwnername(ownername);
  }

  public void submit() {
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

}
