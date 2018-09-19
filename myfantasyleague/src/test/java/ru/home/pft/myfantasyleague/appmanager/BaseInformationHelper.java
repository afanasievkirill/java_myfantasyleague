package ru.home.pft.myfantasyleague.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.home.pft.myfantasyleague.model.InformationData;

public class BaseInformationHelper extends HelperBase{

  public BaseInformationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void SubmitFranchiseInformation() {
    click(By.xpath("//input[@value='Save Franchise Information']"));
  }

  public void FillBaseInformationForm(InformationData informationData) {
    type(By.name("FRANCHISE_NAME0043"), informationData.getFranchisename());
    type(By.name("FRANCHISE_OWNER_NAME0043"), informationData.getOwnername());
  }

}
