import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Stylist {
  private int id;
  private String name;
  private String phone;
  private String location;
  private List<Client> clientList;

  public Stylist(String name, String phone, String location) {
    this.name = name;
    this.phone = phone;
    this.location = location;
  }
  
  public int getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getId() == newStylist.getId();
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()){
      String sql = "INSERT INTO stylists(name, phone, location) VALUES (:name, :phone, :location)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("phone", this.phone)
      .addParameter("location", this.location)
      .executeUpdate()
      .getKey();
    }
  }

  public static List<Stylist> all(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists";
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }


  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist stylist = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }
}






