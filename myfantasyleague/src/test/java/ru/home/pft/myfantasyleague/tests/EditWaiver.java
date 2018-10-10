package ru.home.pft.myfantasyleague.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class EditWaiver extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().waiver();
    if (!app.waiver().isThereRequest()) {
      app.waiver().addRequest(new PlayerData()
              .withPlayerID(testPlayer).withBbid("1").withComment("Редактирование"));
    }
  }

  @Test
  public void testEditWaiver() throws Exception {
    if (app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().editWaiver();
      app.waiver().editFillWaiver("2", "Отредактировано");
      app.waiver().saveWaiverEdit();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  public void testEditWaiverMBB() throws Exception {
    if (app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().editWaiver();
      app.waiver().editFillWaiver("1000", "Отредактировано");
      app.waiver().saveWaiverEdit();
      app.goTo().back();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @AfterMethod
  public void  endingPreconditions(){
    app.goTo().home();
  }
}
