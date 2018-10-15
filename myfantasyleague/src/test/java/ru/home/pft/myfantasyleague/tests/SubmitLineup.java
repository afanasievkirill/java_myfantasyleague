package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.LineupData;


public class SubmitLineup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    app.goTo().lineup();
    app.lineup().clean();
  }

  @Test
  public void testSubmitLineup() throws Exception {
    if (app.lineup().itsLineupTime()) {
      LineupData lineup = new LineupData().withQb("Trubisky, Mitchell CHI QB").withRb1("Elliott, Ezekiel DAL RB")
              .withRb2("Jones, Aaron GBP RB").withWr1("Diggs, Stefon MIN WR").withWr2("Funchess, Devin CAR WR")
              .withWr3("Thomas, Demaryius DEN WR").withTe("Kittle, George SFO TE").withSflex("Mariota, Marcus TEN QB");
      app.lineup().fiilLineup(lineup);
      app.lineup().submit();
      app.goTo().home();
    }
  }
}
