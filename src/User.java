
import java.sql.*;

import javax.persistence.*;

@Entity
@Table(name="preferences")
public class User {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="preferenceString")
	private String preferenceString;
	
	public User(String name) {
		this.name = name;
		this.preferenceString = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
	}
	
	public User(String name, String preferenceString) {
		this.name = name;
		this.preferenceString = preferenceString;
	}
	
	public User(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreferenceString() {
		return preferenceString;
	}

	public void setPreferenceString(String preferenceString) {
		this.preferenceString = preferenceString;
	}

	public void changeName(String newName) throws SQLException{
		this.name = newName;
	}
	
	public void changePreferenceString(String preferenceString) throws SQLException{
		this.preferenceString = preferenceString;
	}
}
