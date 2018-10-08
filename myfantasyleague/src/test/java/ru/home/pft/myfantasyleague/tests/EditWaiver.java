package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class EditWaiver extends TestBase{

  @Test
  public void testAddPlayer() throws Exception {
    app.goTo().goToWaiver();
    if (!app.waiver().isThereRequest()){
      app.waiver().addRequest(new PlayerData()
              .withPlayerID("//tr[@id='add_176']/td").withBbid("1").withComment("Редактирование"));
    }
    app.waiver().editWaiver();
    app.waiver().editFillWaiver("2", "Отредактировано");
    app.waiver().saveWaiverEdit();
  }

}
