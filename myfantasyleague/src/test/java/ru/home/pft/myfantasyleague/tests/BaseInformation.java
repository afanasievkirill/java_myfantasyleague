package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.InformationData;

public class BaseInformation extends TestBase {

  @Test
  public void testFranchiseBasicInformation() throws Exception {
    app.getNavigationHelper().GoToFranchiseInformation();
    app.getBaseInformationHelper().FillBaseInformationForm(new InformationData("Supir Mario Bros", "SupirPuper"));
    app.getNavigationHelper().SubmitFranchiseInformation();
  }
}
