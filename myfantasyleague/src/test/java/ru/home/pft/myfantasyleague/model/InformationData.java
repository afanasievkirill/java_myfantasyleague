package ru.home.pft.myfantasyleague.model;

import java.util.Objects;

public class InformationData {
  private String franchisename;
  private String ownername;


  public InformationData withFranchisename(String franchisename) {
    this.franchisename = franchisename;
    return this;
  }

  public InformationData withOwnername(String ownername) {
    this.ownername = ownername;
    return this;
  }

  public String getFranchisename() {
    return franchisename;
  }

  public String getOwnername() {
    return ownername;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    InformationData that = (InformationData) o;
    return Objects.equals(franchisename, that.franchisename) &&
            Objects.equals(ownername, that.ownername);
  }

  @Override
  public int hashCode() {
    return Objects.hash(franchisename, ownername);
  }

  @Override
  public String toString() {
    return "InformationData{" +
            "franchisename='" + franchisename + '\'' +
            ", ownername='" + ownername + '\'' +
            '}';
  }
}
