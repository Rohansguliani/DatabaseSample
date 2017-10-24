
import java.sql.*;
//import java.util.*;
import java.io.*;

public class OldDriver {

	public static void main(String[] args) throws FileNotFoundException, SQLException, InterruptedException {

		/*
		String url = "jdbc:mysql://localhost:3306/preferences";
		String username = "root";
		String pass = "Theylead123";
		Connection myConn = DriverManager.getConnection(url, username, pass);
		Statement myStmt = myConn.createStatement();
		ResultSet myRs;
		Scanner scan = new Scanner(System.in);
		List<User> users = new ArrayList<>();
		Map<Integer, String> preferenceMap = getPreferenceMap();
		String choices = "Type 'n' to create a new user, \n" + "Type 'l' to load an existing user, \n"
				+ "Type 'quit' to quit.";
		System.out.println("Welcome to the Vuko App Preferences Demo. \n" + choices);
		String line = scan.nextLine();
		while (!(line.equals("Quit")) || (!line.equals("quit"))) {
			if (line.equals("n")) {
				System.out.println("Enter the name");
				String name = scan.nextLine();
				System.out.println("Do you want to enter a preferenceString? (y/n)");
				String response = scan.nextLine();
				String preferenceString;
				User newUser;
				if (response.equals("y")) {
					System.out.println("Enter the preferenceString");
					preferenceString = scan.nextLine();
					newUser = new User(users.size() + 1, name, preferenceString);
				} else {
					newUser = new User(users.size() + 1, name);
				}
				users.add(newUser);
				System.out.println(name + " added.");

			} else if (line.equals("l")) {
				System.out.println("Enter name of user");
				String name = scan.nextLine();
				myRs = myStmt.executeQuery("select * from preferences");

				while (myRs.next()) {
					
					String possName = myRs.getString("name");
					if (possName.equals(name)) {
						//User target = users.get(myRs.getInt("id")-1);
						System.out.println("User " + name + " loaded\n");
						String userChoices = "Type 'i' to inspect a user preference, \n"
								+ "Type 'c' to change a user preference, \n" + "Type 'quit' to quit.";
						System.out.println(userChoices);
						String answer = scan.nextLine();
						while (!answer.equals("quit") || !answer.equals("Quit")) {
							System.out.println("Enter name of preference: ");
							String prefName = scan.nextLine();
							String prefString = myRs.getString("preferenceString");
							if (answer.equals("i")) {
								for (int id : preferenceMap.keySet()) {
									if (preferenceMap.get(id).equals(prefName)) {
										System.out.println(
												"Preference " + prefName + " has a rating of " + prefString.charAt(id));
										break;
									}
								}
							} else if (answer.equals("c")) {
								System.out.println("Enter the new rating you would like: ");
								int newRating = scan.nextInt();
								for (int id : preferenceMap.keySet()) {
									if (preferenceMap.get(id).equals(prefName)) {
										String newPrefString = prefString.substring(0, id) + newRating
												+ prefString.substring(id + 1, prefString.length());
										String query = "update preferences " 
												     + " set preferenceString='" + newPrefString
												     + "'" + " where id=" + 1;
										myStmt.executeUpdate(query);
										System.out.println("Preference '" + prefName + "' Updated");
									}
								}
							}
							else{
								break;
							}
							System.out.println(userChoices);
							answer = scan.nextLine();
						}
						break;
					}
				}
			}
			else{
				break;
			}
			System.out.println(choices);
			line = scan.nextLine();
		}*/

		/*
		String preferenceString1 = "391319134849184148485843941809538529485395924853928458393284569485722328403248434324563223213458383292";
		User user1 = new User(1, "Rohan", preferenceString1);
		user1.changeName("Jasmine");

		Thread.sleep(10000);

		user1.deleteUser();*/
	} 

}
