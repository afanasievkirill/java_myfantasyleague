package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SubmitLineup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToLineup();
    app.lineup().clean();
  }

  @Test
  public void testSubmitLineup() throws Exception {
    app.lineup().fiilLineup();
    app.lineup().submit();
  }
}
