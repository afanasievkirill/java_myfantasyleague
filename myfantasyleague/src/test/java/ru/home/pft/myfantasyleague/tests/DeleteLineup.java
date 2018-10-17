package ru.home.pft.myfantasyleague.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteLineup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().lineup();
  }

  @Test
  public void testDeleteLineup() throws InterruptedException {
    app.lineup().delete();
  }

  @AfterMethod
  public void endingPreconditions(){
    app.goTo().home();
  }

}
