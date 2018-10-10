package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.ContactData;

public class ContactInformation extends TestBase {

  @Test
  public void testContactInformation() throws Exception {
    app.goTo().Contact();
    app.franchise().fillContactInformation(new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withZip("test2").withTwitter("supirpuper"));
    app.franchise().flagUp("FRANCHISE_MAIL_EVENT0043AUCTION");
    app.goTo().submit();
    app.goTo().home();
  }

  @Test
  public void testContactInformationTD() throws Exception {
    app.goTo().contactTD();
    app.franchise().fillContactInformation(new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withZip("test2").withTwitter("supirpuper"));
    app.franchise().flagUp("FRANCHISE_MAIL_EVENT0043AUCTION");
    app.goTo().submit();
    app.goTo().home();
  }
}
