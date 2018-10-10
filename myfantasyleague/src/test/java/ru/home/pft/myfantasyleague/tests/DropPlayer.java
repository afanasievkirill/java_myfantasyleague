package ru.home.pft.myfantasyleague.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class DropPlayer extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().waiver();
  }

  @Test(enabled = false)
  public void testDropPlayer() throws Exception {
    int before = app.waiver().getPlayerCount();
    app.waiver().dpopPlayer(new PlayerData().withPlayerID("//tr[@id='drop_15']/td"));
    app.waiver().submit();
    int after = app.waiver().getPlayerCount();
    Assert.assertEquals(after, before - 1);
  }

  @AfterMethod
  public void endingPreconditions() {
    app.goTo().home();
  }

}
