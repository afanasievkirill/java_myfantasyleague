package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.ContactData;

public class ContactInformation extends TestBase {

  @AfterMethod
  public void ensurePreconditions(){
    app.goTo().Contact();
  }

  @Test
  public void testContactInformation() throws Exception {
        app.franchise().fillContact(new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withZip("test2").withTwitter("supirpuper"));
    app.franchise().flagUp("FRANCHISE_MAIL_EVENT0043AUCTION");
  }

  @Test
  public void testContactInformationTD() throws Exception {
    app.franchise().fillContact(new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withZip("test2").withTwitter("supirpuper"));
    app.franchise().flagUp("FRANCHISE_MAIL_EVENT0043AUCTION");
  }

  @AfterMethod
  public void  endingPreconditions(){
    app.goTo().home();
  }
}
