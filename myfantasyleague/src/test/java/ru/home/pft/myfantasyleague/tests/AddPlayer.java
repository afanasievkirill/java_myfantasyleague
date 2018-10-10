package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddPlayer extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().waiver();
    if (app.waiver().isThereRequest()) {
      app.waiver().deletePlayer();
    }
  }

  @Test
  public void AddPlayer() {
    if (!app.waiver().itsWaiver()) {

    }
  }

  @AfterMethod
  public void endingPreconditions() {
    app.goTo().home();
  }

}
