package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.ContactData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInformation extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().Contact();
  }

  @DataProvider
  public Iterator<Object[]> validCustomizeInformation() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withDayphone("1234567").withHomephone("7654321")
            .withStreet("test").withCity("test1").withState("DC").withZip("test2").withTwitter("supirpuper")});
    return list.iterator();
  }

  @Test(dataProvider = "validCustomizeInformation")
  public void testContactInformation(ContactData contact) throws Exception {
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
    String address = contact.getStreet() + " " + contact.getCity() + ", " + contact.getState() + " " + contact.getZip();
    return address;
  }

  private String mergeTwitter(ContactData contact) {
    String twitter = "http://twitter.com/" + contact.getTwitter();
    return twitter;
  }
}
