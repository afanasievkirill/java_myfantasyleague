package ru.home.pft.myfantasyleague;

public class BasicInformationData {
  private final String franchisename;
  private final String ownername;

  public BasicInformationData(String franchisename, String ownername) {
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
