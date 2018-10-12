package ru.home.pft.myfantasyleague.model;

public class LineupData {
  private  String player;
  private double projectPoint;
  private String qb;
  private String rb1;
  private String rb2;
  private String wr1;
  private String wr2;
  private String wr3;
  private String te;
  private String sflex;

  public String getPlayer() {
    return player;
  }

  public double getProjectPoint() {
    return projectPoint;
  }

  public String getQb() {
    return qb;
  }

  public String getRb1() {
    return rb1;
  }

  public String getRb2() {
    return rb2;
  }

  public String getWr1() {
    return wr1;
  }

  public String getWr2() {
    return wr2;
  }

  public String getWr3() {
    return wr3;
  }

  public String getTe() {
    return te;
  }

  public String getSflex() {
    return sflex;
  }

  public LineupData withPlayer(String player) {
    this.player = player;
    return this;
  }

  public LineupData withProjectPoint(double projectPoint) {
    this.projectPoint = projectPoint;
    return this;
  }

  public LineupData withQb(String qb) {
    this.qb = qb;
    return this;
  }

  public LineupData withRb1(String rb1) {
    this.rb1 = rb1;
    return this;
  }

  public LineupData withRb2(String rb2) {
    this.rb2 = rb2;
    return this;
  }

  public LineupData withWr1(String wr1) {
    this.wr1 = wr1;
    return this;
  }

  public LineupData withWr2(String wr2) {
    this.wr2 = wr2;
    return this;
  }

  public LineupData withWr3(String wr3) {
    this.wr3 = wr3;
    return this;
  }

  public LineupData withTe(String te) {
    this.te = te;
    return this;
  }

  public LineupData withSflex(String sflex) {
    this.sflex = sflex;
    return this;
  }
}
