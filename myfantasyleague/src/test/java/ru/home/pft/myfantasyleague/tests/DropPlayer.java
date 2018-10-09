package ru.home.pft.myfantasyleague.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class DropPlayer extends TestBase {

  @Test
  public void testDropPlayer() throws Exception {
    int before = app.waiver().getPlayerCount();
    app.goTo().goToWaiver();
    app.waiver().DpopPlayer(new PlayerData().withPlayerID("//tr[@id='drop_15']/td"));
    app.waiver().submit();
    int after = app.waiver().getPlayerCount();
    Assert.assertEquals(after, before-1);
  }
}
