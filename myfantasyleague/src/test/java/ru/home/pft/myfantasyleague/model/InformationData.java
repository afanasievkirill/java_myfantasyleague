package ru.home.pft.myfantasyleague.model;

public class InformationData {
  private final String franchisename;
  private final String ownername;

  public InformationData(String franchisename, String ownername) {
    this.franchisename = franchisename;
    this.ownername = ownername;
  }

  public String getFranchisename() {
    return franchisename;
  }

  public String getOwnername() {
    return ownername;
  }
}
