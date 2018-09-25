package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.ContactData;

public class ContactInformation extends TestBase {

  @Test
  public void testContactInformation() throws Exception {
    app.getNavigationHelper().goToContactInformation();
    app.getContactHelper().fillContactInformation(new ContactData("1234567", "7654321", "test", "test1", "test2", "supirpuper"));
    app.getContactHelper().flagUp("FRANCHISE_MAIL_EVENT0043AUCTION");
    app.getNavigationHelper().submitFranchiseInformation();
  }
}
