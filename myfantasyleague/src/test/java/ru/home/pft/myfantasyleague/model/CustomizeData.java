package ru.home.pft.myfantasyleague.model;

import java.io.File;
import java.util.Objects;

public class CustomizeData {
  private String abbriveation;
  private String stadium;
  private String note;
  private String timezone;
  private File franchiseIcon;
  private File franchiseLogo;

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

  public CustomizeData withTimezone(String timezone) {
    this.timezone = timezone;
    return this;
  }

  public CustomizeData withFranchiseIcon(File franchiseIcon) {
    this.franchiseIcon = franchiseIcon;
    return this;
  }

  public CustomizeData withFranchiseLogo(File franchiseLogo) {
    this.franchiseLogo = franchiseLogo;
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

  public String getTimezone() {
    return timezone;
  }


  public File getFranchiseIcon(){
    return franchiseIcon;
  }

  public File getFranchiseLogo(){
    return franchiseLogo;
  }

  @Override
  public String toString() {
    return "CustomizeData{" +
            "abbriveation='" + abbriveation + '\'' +
            ", stadium='" + stadium + '\'' +
            ", note='" + note + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomizeData that = (CustomizeData) o;
    return Objects.equals(stadium, that.stadium) &&
            Objects.equals(note, that.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stadium, note);
  }
}
