package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class DeleteWaiver extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().waiver();
    if(app.waiver().itsWaiver()) {
      if (!app.waiver().isThereRequest()) {
        app.waiver().addRequest(new PlayerData()
                .withPlayerID(testPlayer).withBbid("1").withComment("Редактирование"));
      }
    }
  }

  @Test
  public void testAddPlayer() throws Exception {
    if (app.waiver().itsWaiver()) {
      app.waiver().deletePlayer();
      app.waiver().submit();
    }
  }

  @AfterMethod
  public void  endingPreconditions(){
    app.goTo().home();
  }

}
