package ru.home.pft.myfantasyleague.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.*;
import ru.home.pft.myfantasyleague.model.ContactData;
import org.hamcrest.MatcherAssert;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInformation extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().Contact();
  }

  @Test
  public void testContactInformation() throws Exception {
    ContactData contact = new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withZip("test2").withTwitter("supirpuper");
    app.franchise().fillContact(contact, "FRANCHISE_MAIL_EVENT0043AUCTION");
    ContactData contactFromFranchiseHome = app.franchise().contactFromFranchiseHome(contact);
    assertThat(contactFromFranchiseHome.getAddress(), equalTo(mergeAddress(contact)));
    assertThat(contactFromFranchiseHome.getTwitter(), equalTo(mergeTwitter(contact)));
    assertThat(contact, equalTo(contactFromFranchiseHome));
  }

  @Test
  public void testContactInformationTD() throws Exception {
    ContactData contact = new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withZip("test2").withTwitter("supirpuper");
    app.franchise().fillContact(contact, "FRANCHISE_MAIL_EVENT0043AUCTION");
  }

  @AfterMethod
  public void endingPreconditions() {
    app.goTo().home();
  }

  private String mergeAddress(ContactData contact) {
    String address = contact.getStreet() + " " + contact.getCity() + ", " + contact.getZip();
    return address;
  }

  private String mergeTwitter(ContactData contact) {
    String twitter = "http://twitter.com/"+contact.getTwitter();
    return twitter;
  }
}
