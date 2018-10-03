package ru.home.pft.myfantasyleague.model;

public class LineupData {
  private  String player;
  private int projectPoint;

  public LineupData(String player, int projectPoint) {
    this.player = player;
    this.projectPoint = projectPoint;
  }

  public String getPlayer() {
    return player;
  }

  public int getProjectPoint() {
    return projectPoint;
  }
}
