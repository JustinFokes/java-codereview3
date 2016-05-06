import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

import static org.assertj.core.api.Assertions.assertThat;
public class AppTest extends FluentTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Salon Name");
  }

  @Test
  public void stylistIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add A Stylist"));
    fill("#name").with("Breanna");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void StylistNameIsDisplayedTest() {
    goTo("http://localhost:4567/stylists/new");
    fill("#name").with("Breanna");
    submit(".btn");
    click("a", withText("Home"));
    assertThat(pageSource()).contains("Breanna");
  }

  @Test
  public void stylistClientFormIsDisplayed() {
    goTo("http://localhost:4567/stylists/new");
    fill("#name").with("Breanna");
    submit(".btn");
    click("a", withText("Home"));
    click("a", withText("Breanna"));
    assertThat(pageSource()).contains("Add a new client with details about appointment");
  }

  @Test
  public void clickingStylistDisplaysClients() {
    goTo("http://localhost:4567/stylists/new");
    fill("#name").with("Jolene");
    submit(".btn");
    click("a", withText("Home"));
    click("a", withText("Jolene"));
    click("a", withText("Add a new client with details about appointment"));
    fill("name").with("Jacob");
    submit(".btn");
    click("a", withText("Home"));
    click("a", withText("Jolene"));
    assertThat(pageSource()).contains("Jacob");
  }
}
