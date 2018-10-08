package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.WaiverData;

public class AddWaiver extends TestBase {

  @Test
  public void testAddPlayer() throws Exception {
    app.goTo().goToWaiver();
    app.getWaiverHelper().fillWaiverData(new WaiverData("//tr[@id='add_172']/td", "1", "Тест"));
    app.getWaiverHelper().submitWaiverRequest();

  }
}
