package ru.home.pft.myfantasyleague;

import org.testng.annotations.*;

public class FranchiseInformation extends TestBase {

  @Test
  public void testFranchiseBasicInformation() throws Exception {

    GoToFranchiseInformation();
    FillFranchiseInformationForm(new BasicInformationData("Supir Mario Bros", "SupirPuper"));
    SubmitFranchiseInformation();

  }


}
