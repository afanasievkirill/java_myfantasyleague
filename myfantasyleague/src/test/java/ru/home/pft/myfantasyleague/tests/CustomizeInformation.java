package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.CustomizeData;

public class CustomizeInformation extends TestBase {

  @Test
  public void testCustomizeInformation() throws Exception{
    app.getNavigationHelper().goToCustomizeInformation();
    app.getCustomizeInformationHelper().fillCustomizeInformation(new CustomizeData("SMB", "OneMileHigh", "Test"));
    app.getCustomizeInformationHelper().fillTimeZone("CT");
    app.getNavigationHelper().submitFranchiseInformation();
  }

}
