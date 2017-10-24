
import java.sql.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;

public class newDriver {

	public static Map<Integer, String> getPreferenceMap() throws FileNotFoundException {
		Map<Integer, String> preferenceMap = new HashMap<>();
		List<String> preferences = getPreferences();

		int i = 1;
		for (String preference : preferences) {
			preferenceMap.put(i, preference);
			i++;
		}
		return preferenceMap;

	}

	public static List<String> getPreferences() throws FileNotFoundException {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(new File("src/preferences.txt"));
		List<String> prefs = new ArrayList<>();
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			prefs.add(line);
		}
		return prefs;
	}
	
	public static void addNewUser(String name, Session session) {
		session.beginTransaction();
		User newUser;
		newUser = new User(name);
		session.save(newUser);
		System.out.println(name + " added.");
		session.getTransaction().commit();
		
	}

	public static void main(String[] args) throws FileNotFoundException, SQLException, InterruptedException {

		Scanner scan = new Scanner(System.in);
		Map<Integer, String> preferenceMap = getPreferenceMap();

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				                 .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			String choices = "Type 'n' to create a new user, \n" + "Type 'l' to load an existing user, \n"
					       + "Type 'quit' to quit.";
			System.out.println("Welcome to the Vuko App Preferences Demo. \n" + choices);
			String line = scan.nextLine();
			while (!(line.equals("Quit")) || (!line.equals("quit"))) {
				if (line.equals("n")) {
					System.out.println("Enter the name");
					String name = scan.nextLine();
					addNewUser(name, session);

				} else if (line.equals("l")) {
					session.beginTransaction();
					List<User> users = session.createQuery("from User").list();
					System.out.println("Enter name of user");
					String name = scan.nextLine();
					
					for(User user: users){
						if(user.getName().equals(name)){
							System.out.println("User " + name + " loaded\n");
							String userChoices = "Type 'i' to inspect a user preference, \n"
								               + "Type 'c' to change a user preference, \n" + "Type 'quit' to quit.";
							System.out.println(userChoices);
							String answer = scan.nextLine();
							while ((!answer.equals("quit")) || (!answer.equals("Quit"))) {
								System.out.println("Enter name of preference: ");
								String prefName = scan.nextLine();
								String prefString = user.getPreferenceString();
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
											user.changePreferenceString(newPrefString);
											System.out.println("Preference '" + prefName + "' Updated");
											session.getTransaction().commit();
											
											break;
										}
									}
								} else {
									break;
								}
								System.out.println(userChoices);
								answer = scan.nextLine();
							}
							break;
						}
					}
						
				} else {
					break;
				}
				System.out.println(choices);
				line = scan.nextLine();
			}

		} finally  {
			factory.close();
		}
		
	}

}
