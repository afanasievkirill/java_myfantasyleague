package ru.home.pft.myfantasyleague.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.PlayerData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class AddWaiver extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/testData/AddWaiver-valid.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<PlayerData> players = gson.fromJson(json, new TypeToken<List<PlayerData>>() {
    }.getType()); //list<GroupData>.class
    return players.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> invalidGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/testData/AddWaiver-invalid.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<PlayerData> players = gson.fromJson(json, new TypeToken<List<PlayerData>>() {
    }.getType()); //list<GroupData>.class
    return players.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @BeforeMethod
  public void  ensurePreconditions(){
    app.goTo().waiver();
    if (app.waiver().isThereRequest()){
      app.waiver().deletePlayer();
    }
  }

  @Test (dataProvider = "validGroupsFromJson")
  public void testAddRequest(PlayerData player) throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(player);
      app.waiver().submit();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @Test (dataProvider = "invalidGroupsFromJson")
  public void testAddInvalidRequest(PlayerData player) throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(player);
      app.waiver().submit();
      app.goTo().backWaiver();
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before);
    }
  }

  @Test (dataProvider = "validGroupsFromJson")
  public void testAddRequestCansel(PlayerData player) throws Exception {
    if(app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().fillRequest(player);
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
