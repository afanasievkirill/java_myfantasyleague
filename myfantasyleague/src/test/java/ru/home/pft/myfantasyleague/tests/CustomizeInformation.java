package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.CustomizeData;

public class CustomizeInformation extends TestBase {

  @Test
  public void testCustomizeInformation() throws Exception{
    app.goTo().goToCustomizeInformation();
    app.franchise().fillCustomizeInformation(new CustomizeData("SMB", "OneMileHigh", null));
    app.franchise().fillTimeZone("CT");
    app.goTo().submit();
  }

}
