package ru.home.pft.myfantasyleague.model;

public class ContactData {
  private String dayphone;
  private String homephone;
  private String street;
  private String city;
  private String zip;
  private String twitter;

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

  public ContactData withDayphone(String dayphone) {
    this.dayphone = dayphone;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withStreet(String street) {
    this.street = street;
    return this;
  }

  public ContactData withCity(String city) {
    this.city = city;
    return this;
  }

  public ContactData withZip(String zip) {
    this.zip = zip;
    return this;
  }

  public ContactData withTwitter(String twitter) {
    this.twitter = twitter;
    return this;
  }
}
