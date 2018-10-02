package ru.home.pft.myfantasyleague.model;

public class WaiverData {
  private final String player;
  private final String bbid;
  private final String comment;

  public WaiverData(String player, String bbid, String comment) {
    this.player = player;
    this.bbid = bbid;
    this.comment = comment;
  }

  public WaiverData(String player) {
    this.player = player;
    this.bbid = null;
    this.comment = null;
  }

  public String getPlayer() {
    return player;
  }

  public String getBbid() {
    return bbid;
  }

  public String getComment() {
    return comment;
  }
}
