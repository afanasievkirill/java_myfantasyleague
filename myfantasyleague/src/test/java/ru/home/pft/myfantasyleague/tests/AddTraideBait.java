package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTraideBait extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().bait();
    if(app.bait().isThereBait()){
      app.bait().delete();
    }
  }

  @Test
  public void testAddTraideBait(){

  }
}
