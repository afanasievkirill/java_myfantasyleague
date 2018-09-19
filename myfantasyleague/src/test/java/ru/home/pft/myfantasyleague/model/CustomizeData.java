package ru.home.pft.myfantasyleague.model;

public class CustomizeData {
  private final String abbriveation;
  private final String stadium;
  private final String note;

  public CustomizeData(String abbriveation, String stadium, String note) {
    this.abbriveation = abbriveation;
    this.stadium = stadium;
    this.note = note;
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
