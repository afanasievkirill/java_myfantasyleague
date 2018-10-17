package ru.home.pft.myfantasyleague.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.LineupData;
import ru.home.pft.myfantasyleague.model.PlayerData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class SubmitLineup extends TestBase {

  @DataProvider
  public Iterator<Object[]> lineupFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/testData/SubmitLineup-valid.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<PlayerData> lineups = gson.fromJson(json, new TypeToken<List<PlayerData>>() {
    }.getType());
    return lineups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().lineup();
    if (app.lineup().itsLineupTime()) {
      app.lineup().clean();
    }
  }

  @Test (dataProvider = "lineupFromJson")
  public void testSubmitLineup(LineupData lineups) throws Exception {
    if (app.lineup().itsLineupTime()) {
 /*     LineupData lineup = new LineupData().withQb("Trubisky, Mitchell CHI QB").withRb1("Elliott, Ezekiel DAL RB")
              .withRb2("Jones, Aaron GBP RB").withWr1("Diggs, Stefon MIN WR").withWr2("Funchess, Devin CAR WR")
              .withWr3("Thomas, Demaryius DEN WR").withTe("Kittle, George SFO TE").withSflex("Mariota, Marcus TEN QB"); */
      app.lineup().fiilLineup(lineups);
      app.lineup().submit();
    }
  }

  @AfterMethod
  public void endingPreconditions(){
    app.goTo().home();
  }
}
