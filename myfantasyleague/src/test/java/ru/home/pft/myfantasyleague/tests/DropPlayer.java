package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.WaiverData;

public class DropPlayer extends TestBase {

  @Test
  public void testDropPlayer() throws Exception{
    app.getNavigationHelper().goToWaiver();
    app.getWaiverHelper().DpopPlayer(new WaiverData("//tr[@id='drop_15']/td", null, null));
    app.getWaiverHelper().submitWaiverRequest();
  }
}
