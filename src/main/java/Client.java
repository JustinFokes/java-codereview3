import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {
	private int id;
	private String name;
	private String phone;
	private String requestedDate;
	private String clientRequests;
	private int stylistId;

	public Client(String name, String phone, String requestedDate, String clientRequests) {
		this.name = name;
		this.phone = phone;
		this.requestedDate = requestedDate;
		this.clientRequests = clientRequests;
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

	public String getRequestedDate() {
		return requestedDate;
	}

	public String getClientRequests() {
		return clientRequests;
	}

	public static List<Client> all() {
    	try(Connection con = DB.sql2o.open()){
      		String sql = "SELECT * FROM clients";
      		return con.createQuery(sql).executeAndFetch(Client.class);
    	}
  	}


	public void saveClientToStylist(int inputId) {
	    try(Connection con = DB.sql2o.open()){
		    String sql = "INSERT INTO clients(name, phone, requestedDate, clientRequests, stylistId) VALUES (:name, :phone, :requestedDate, :clientRequests, :stylistId)";
		    this.stylistId = inputId;
		    this.id = (int) con.createQuery(sql, true)
		    .addParameter("name", this.name)
		    .addParameter("phone", this.phone)
		    .addParameter("requestedDate", this.requestedDate)
		    .addParameter("clientRequests", this.clientRequests)
		    .addParameter("stylistId", this.stylistId)
		    .executeUpdate()
		    .getKey();
		}
	}

	public static Client find(int id) {
	    try(Connection con = DB.sql2o.open()){
		    String sql = "SELECT * FROM clients WHERE id=:id";
		    Client client = con.createQuery(sql)
		    .addParameter("id", id)
		    .executeAndFetchFirst(Client.class);
		    return client;
    	}
  	}

  	public static List<Client> getClients(int id) {
	    try(Connection con = DB.sql2o.open()){
		    String sql = "SELECT * FROM clients WHERE stylistId=:id";
		    return con.createQuery(sql)
		    .addParameter("id", id)
		    .executeAndFetch(Client.class);
		}
	}
}





