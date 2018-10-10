package ru.home.pft.myfantasyleague.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

public class AddWaiver extends TestBase {

  @BeforeMethod
  public void  ensurePreconditions(){
    app.goTo().waiver();
    if (app.waiver().isThereRequest()){
      app.waiver().deletePlayer();
    }
  }

  @Test
  public void testAddRequest() throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      //Players before1 = app.waiver().all();
      app.waiver().fillRequest(new PlayerData().
              withPlayerID(testPlayer).withBbid("1").withComment("Тест"));
      app.waiver().submit();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @Test
  public void testAddRequestMBB() throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(new PlayerData().
              withPlayerID(testPlayer).withBbid("1000").withComment("Тест"));
      app.waiver().submit();
      app.goTo().backWaiver();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @Test
  public void testAddRequestRevBB() throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(new PlayerData().
              withPlayerID(testPlayer).withBbid("-1000").withComment("Тест"));
      app.waiver().submit();
      app.goTo().backWaiver();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @Test
  public void testAddRequestFrBB() throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(new PlayerData().
              withPlayerID(testPlayer).withBbid("1.5").withComment("Тест"));
      app.waiver().submit();
      app.goTo().backWaiver();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @Test
  public void testAddRequestCansel() throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(new PlayerData().
              withPlayerID(testPlayer).withBbid("1").withComment("Тест"));
      app.goTo().back();
      app.goTo().waiver();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @AfterMethod
  public void  endingPreconditions(){
    app.goTo().home();
  }
}
