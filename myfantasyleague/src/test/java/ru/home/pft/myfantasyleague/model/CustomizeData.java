package ru.home.pft.myfantasyleague.model;

public class CustomizeData {
  private String abbriveation;
  private String stadium;
  private String note;

  public CustomizeData withAbbriveation(String abbriveation) {
    this.abbriveation = abbriveation;
    return this;
  }

  public CustomizeData withStadium(String stadium) {
    this.stadium = stadium;
    return this;
  }

  public CustomizeData withNote(String note) {
    this.note = note;
    return this;
  }

  public String getAbbriveation() {
    return abbriveation;
  }

  public String getStadium() {
    return stadium;
  }

  public String getNote() {
    return note;
  }
}
