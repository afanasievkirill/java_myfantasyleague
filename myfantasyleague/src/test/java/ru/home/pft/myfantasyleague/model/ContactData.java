package ru.home.pft.myfantasyleague.model;

public class ContactData {
  private final String dayphone;
  private final String homephone;
  private final String street;
  private final String city;
  private final String zip;
  private final String twitter;

  public ContactData(String dayphone, String homephone, String street, String city, String zip, String twitter) {
    this.dayphone = dayphone;
    this.homephone = homephone;
    this.street = street;
    this.city = city;
    this.zip = zip;
    this.twitter = twitter;
  }

  public String getDayphone() {
    return dayphone;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getZip() {
    return zip;
  }

  public String getTwitter() {
    return twitter;
  }
}
