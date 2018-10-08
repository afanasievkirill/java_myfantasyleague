package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.ContactData;

public class ContactInformation extends TestBase {

  @Test
  public void testContactInformation() throws Exception {
    app.goTo().goToContactInformation();
    app.franchise().fillContactInformation(new ContactData("1234567", "7654321", "test", "test1", "test2", "supirpuper"));
    app.franchise().flagUp("FRANCHISE_MAIL_EVENT0043AUCTION");
    app.goTo().submit();
  }
}
