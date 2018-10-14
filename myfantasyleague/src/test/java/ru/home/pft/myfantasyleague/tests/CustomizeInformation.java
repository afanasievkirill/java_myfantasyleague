package ru.home.pft.myfantasyleague.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.home.pft.myfantasyleague.model.CustomizeData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizeInformation extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().customizeTD();
  }

  @DataProvider
  public Iterator<Object[]> validCustomizeInformation(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new CustomizeData()
            .withAbbriveation("SMB").withStadium("OneMileHigh").withNote("Позитивный тест")
            .withFranchiseIcon(new File("src/test/resources/logo.png")).withTimezone("CT")});
    return list.iterator();
  }

  @Test
  public void testCustomizeInformation() throws Exception{
    CustomizeData customize = new CustomizeData()
            .withAbbriveation("SMB").withStadium("OneMileHigh").withNote("Позитивный тест")
            .withFranchiseIcon(new File("src/test/resources/logo.png")).withTimezone("CT");
    app.franchise().customize(customize);
    CustomizeData customiseFromFranchiseHome = app.franchise().infoFromeFranchiseHomeForm(customize);
    assertThat(customize, equalTo(customiseFromFranchiseHome));
  }

  @Test
  public void testBadCustomizeInformation() throws Exception{
    CustomizeData customize = new CustomizeData()
            .withAbbriveation("SMB '").withStadium("OneMileHigh '").withNote("Негативный тест '").withTimezone("CT");
    app.franchise().customize(customize);
    CustomizeData customiseFromFranchiseHome = app.franchise().infoFromeFranchiseHomeForm(customize);
    assertThat(customize, equalTo(customiseFromFranchiseHome));
   }

  @AfterMethod
  public void endingPreconditions(){
    app.goTo().home();
  }

}
