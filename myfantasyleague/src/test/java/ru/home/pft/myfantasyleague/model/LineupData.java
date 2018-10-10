package ru.home.pft.myfantasyleague.model;

public class LineupData {
  private  String player;
  private double projectPoint;

  public LineupData(String player, double projectPoint) {
    this.player = player;
    this.projectPoint = projectPoint;
  }

  public String getPlayer() {
    return player;
  }

  public double getProjectPoint() {
    return projectPoint;
  }
}
