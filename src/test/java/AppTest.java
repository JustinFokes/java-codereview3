import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
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
    goTo("http://localhost:4567/words/new");
    click("a", withText("Add A Stylist"));
    fill("#name").with("Jolene");
    submit(".btn");
    click("a", withText("Home"));
    assertThat(pageSource()).contains("Jolene");
  }


}
