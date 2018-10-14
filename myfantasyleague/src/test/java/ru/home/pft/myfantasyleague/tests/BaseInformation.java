package ru.home.pft.myfantasyleague.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.InformationData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseInformation extends TestBase {

  @Test
  public void testFranchiseBasicInformation() throws Exception {
    app.goTo().information();
    InformationData information = new InformationData().
            withFranchisename("Supir Mario Bros").withOwnername("SupirPuper");
    app.franchise().fillForm(information);
    app.goTo().home();
    InformationData homeForm = app.franchise().infoFromeHomeForm(information);
    assertThat(information.getFranchisename(), equalTo(homeForm.getFranchisename()));
  }

  @Test
  public void testFranchiseBasicInformationTD() throws Exception {
    app.goTo().informationTD();
    InformationData information = new InformationData().
            withFranchisename("Supir Mario Bros").withOwnername("SupirPuper");
    app.franchise().fillForm(information);
    app.goTo().home();
    InformationData homeForm = app.franchise().infoFromeHomeForm(information);
    assertThat(information.getFranchisename(), equalTo(homeForm.getFranchisename()));
  }

  @AfterMethod
  public void  endingPreconditions(){
    app.goTo().home();
  }

}
