package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.WaiverData;

public class AddWaiver extends TestBase {

  @Test
  public void testAddPlayer() throws Exception {
    app.getNavigationHelper().goToWaiver();
    if (!app.getWaiverHelper().isTherWaiver()) {
          app.getWaiverHelper().fillFreeAgentData(new WaiverData("//tr[@id='add_172']/td"));
    } else {
      app.getNavigationHelper().goToWaiver();
      app.getWaiverHelper().selectTeam();
      app.getWaiverHelper().fillWaiverData(new WaiverData("//tr[@id='add_172']/td", "1", "Тест"));
      app.getWaiverHelper().submitWaiverRequest();
    }
  }
}
