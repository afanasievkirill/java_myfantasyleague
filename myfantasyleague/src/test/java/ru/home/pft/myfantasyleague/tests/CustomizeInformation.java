package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.CustomizeData;

public class CustomizeInformation extends TestBase {

  @Test
  public void testCustomizeInformation() throws Exception{
    app.goTo().customize();
    app.franchise().customize(new CustomizeData()
            .withAbbriveation("SMB").withStadium("OneMileHigh").withNote(null));
    app.franchise().fillTimeZone("CT");
    app.goTo().submit();
    app.goTo().home();
  }

  @Test
  public void testCustomizeInformationTD() throws Exception{
    app.goTo().customizeTD();
    app.franchise().customize(new CustomizeData()
            .withAbbriveation("SMB").withStadium("OneMileHigh").withNote(null));
    app.franchise().fillTimeZone("CT");
    app.goTo().submit();
    app.goTo().home();
  }

}
