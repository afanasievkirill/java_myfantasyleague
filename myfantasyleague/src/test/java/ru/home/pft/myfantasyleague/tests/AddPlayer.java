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

public class AddPlayer extends TestBase {

  @DataProvider
  public Iterator<Object[]> validPlayerJson() throws IOException {
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
    }.getType());
    return players.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().waiver();
    if (app.waiver().isThereRequest()) {
      app.waiver().deletePlayer();
    }
  }

  @Test (dataProvider = "validPlayerJson")
  public void AddPlayer(PlayerData players) {
    if (!app.waiver().itsWaiver()) {
      int before = app.waiver().getPlayerCount();
      app.waiver().add(players);
      int after = app.waiver().getPlayerCount();
      Assert.assertEquals(after, before+1);
    }
  }

  @AfterMethod
  public void endingPreconditions() {
    app.goTo().home();
  }

}
