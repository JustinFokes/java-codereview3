import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.rules.ExternalResource;
import java.util.ArrayList;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist newStylist = new Stylist("Breanna", "651-295-3827", "South East");
    assertEquals(true, newStylist instanceof Stylist);
  }

  @Test
  public void getName_getsStylistNameCorrectly_String() {
    Stylist newStylist = new Stylist("Breanna", "651-295-3827", "South East");
    assertEquals("Breanna", newStylist.getName());
  }

  @Test
  public void getPhone_getsStylistPhoneNumber_String() {
    Stylist newStylist = new Stylist("Breanna", "651-295-3827", "South East");
    assertEquals("651-295-3827", newStylist.getPhone());
  }

  @Test
  public void getLocation_getsStylistLocationCorrectly_String() {
    Stylist newStylist = new Stylist("Breanna", "651-295-3827", "South East");
    assertEquals("South East", newStylist.getLocation());
  }

  @Test
  public void getStylistId_returnsIdUponSave_int() {
    Stylist newStylist = new Stylist("Breanna", "651-295-3827", "South East");
    newStylist.save();
    assertEquals(Stylist.all().get(0).getId(), newStylist.getId());
  }


  @Test
  public void findStylist_findStylistById_String(){
    Stylist newStylist = new Stylist("Breanna", "651-295-3827", "South East");
    newStylist.save();
    Stylist savedStylist = Stylist.find(newStylist.getId());
    String namedStylist = savedStylist.getName();
    assertEquals("Breanna", namedStylist);
  }
}
