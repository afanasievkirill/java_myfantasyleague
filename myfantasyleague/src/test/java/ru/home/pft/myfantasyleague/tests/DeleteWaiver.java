package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class DeleteWaiver extends TestBase{

  @Test
  public void testAddPlayer() throws Exception {
    app.goTo().goToWaiver();
    if (!app.waiver().isThereRequest()){
      app.waiver().addRequest(new PlayerData()
              .withPlayerID("//tr[@id='add_176']/td").withBbid("1").withComment("Редактирование"));
    }
    app.waiver().deletePlayer();
    app.waiver().submit();
  }


}
