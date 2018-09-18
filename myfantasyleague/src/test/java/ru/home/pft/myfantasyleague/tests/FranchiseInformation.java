package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.InformationData;

public class FranchiseInformation extends TestBase {

  @Test
  public void testFranchiseBasicInformation() throws Exception {

    app.getNavigationHelper().GoToFranchiseInformation();
    app.getFranchiseInformationHelper().FillFranchiseInformationForm(new InformationData("Supir Mario Bros", "SupirPuper"));
    app.getFranchiseInformationHelper().SubmitFranchiseInformation();

  }


}
