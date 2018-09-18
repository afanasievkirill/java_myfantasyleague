package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.BasicInformationData;

public class FranchiseInformation extends TestBase {

  @Test
  public void testFranchiseBasicInformation() throws Exception {

    app.GoToFranchiseInformation();
    app.FillFranchiseInformationForm(new BasicInformationData("Supir Mario Bros", "SupirPuper"));
    app.SubmitFranchiseInformation();

  }


}
