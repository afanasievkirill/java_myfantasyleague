package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.LineupData;

import java.util.List;

public class SubmitLineup extends TestBase {

  @Test
  public void testSubmitLineup() throws Exception {

    app.getNavigationHelper().goToLineup();
    if(app.getLineupHelper().isThereDefoltSubmissionForm()) {
      app.getLineupHelper().goToDefaultSubmissionForm();
    }
    List<LineupData> before = app.getLineupHelper().getLineuplist();

  }
}
