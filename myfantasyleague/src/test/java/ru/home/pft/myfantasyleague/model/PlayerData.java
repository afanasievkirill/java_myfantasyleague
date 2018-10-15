package ru.home.pft.myfantasyleague.model;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayerData that = (PlayerData) o;
    return Totalplayers == that.Totalplayers &&
            Objects.equals(playerID, that.playerID) &&
            Objects.equals(player, that.player) &&
            Objects.equals(bbid, that.bbid) &&
            Objects.equals(comment, that.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerID, player, bbid, comment, Totalplayers);
  }

  @Override
  public String toString() {
    return "PlayerData{" +
            "playerID='" + playerID + '\'' +
            ", bbid='" + bbid + '\'' +
            ", comment='" + comment + '\'' +
            '}';
  }
}
