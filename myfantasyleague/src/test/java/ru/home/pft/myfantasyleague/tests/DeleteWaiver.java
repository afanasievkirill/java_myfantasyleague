package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.WaiverData;

public class DeleteWaiver extends TestBase{

  @Test
  public void testAddPlayer() throws Exception {
    app.getNavigationHelper().goToWaiver();
    if (!app.getWaiverHelper().isThereRequest()){
      app.getWaiverHelper().addRequest(new WaiverData("//tr[@id='add_176']/td", "1", "Редактирование"));
    }
    app.getWaiverHelper().deletePlayer();
    app.getWaiverHelper().submitWaiverRequest();
  }


}
