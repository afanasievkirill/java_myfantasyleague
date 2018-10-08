package ru.home.pft.myfantasyleague.model;

public class PlayerData {
  private String playerID;
  private String player;
  private String bbid;
  private String comment;
  private int Totalplayers;

  public String getPlayerID() {
    return playerID;
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

  public int getTotalplayers() {
    return Totalplayers;
  }

  public PlayerData withTotalplayers(int totalplayers) {
    Totalplayers = totalplayers;
    return this;
  }

  public PlayerData withPlayerID(String playerID) {
    this.playerID = playerID;
    return this;
  }

  public PlayerData withPlayer(String player) {
    this.player = player;
    return this;
  }

  public PlayerData withBbid(String bbid) {
    this.bbid = bbid;
    return this;
  }

  public PlayerData withComment(String comment) {
    this.comment = comment;
    return this;
  }
}
