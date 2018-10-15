package ru.home.pft.myfantasyleague.model;

import java.util.Objects;

public class ContactData {
  private String dayphone;
  private String homephone;
  private String street;
  private String city;
  private String zip;
  private String state;
  private String twitter;
  private String address;

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

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  public String getTwitter() {
    return twitter;
  }

  public String getAddress(){
    return address;
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

  public ContactData withState(String state) {
    this.state = state;
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

  public ContactData withAddress(String address){
    this.address = address;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(dayphone, that.dayphone) &&
            Objects.equals(homephone, that.homephone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dayphone, homephone);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "dayphone='" + dayphone + '\'' +
            ", homephone='" + homephone + '\'' +
            ", street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", zip='" + zip + '\'' +
            ", state='" + state + '\'' +
            ", twitter='" + twitter + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

}
