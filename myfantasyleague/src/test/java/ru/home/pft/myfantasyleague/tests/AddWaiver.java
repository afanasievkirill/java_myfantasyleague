package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.LineupData;
import ru.home.pft.myfantasyleague.model.PlayerData;
import ru.home.pft.myfantasyleague.model.Players;

import java.util.List;

public class AddWaiver extends TestBase {

  @Test
  public void testAddPlayer() throws Exception {
    app.goTo().goToWaiver();
    //PlayerData players = app.waiver().all().iterator().next();
    Players before = app.waiver().all();
    app.waiver().fillRequest(new PlayerData().
            withPlayerID("//tr[@id='add_172']/td").withBbid("1").withComment("Тест"));
    app.waiver().submit();

  }
}
