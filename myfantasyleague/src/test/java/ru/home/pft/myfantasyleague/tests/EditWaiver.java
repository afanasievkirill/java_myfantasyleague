package ru.home.pft.myfantasyleague.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class EditWaiver extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToWaiver();
    if (!app.waiver().isThereRequest()) {
      app.waiver().addRequest(new PlayerData()
              .withPlayerID("//tr[@id='add_176']/td").withBbid("1").withComment("Редактирование"));
    }
  }

  @Test
  public void testAddPlayer() throws Exception {
    if (app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().editWaiver();
      app.waiver().editFillWaiver("2", "Отредактировано");
      app.waiver().saveWaiverEdit();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }
}
