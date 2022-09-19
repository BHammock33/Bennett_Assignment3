package com.coderscampus.myapp.main;

import java.io.IOException;
import java.util.Scanner;
import com.coderscampus.myapp.domain.User;
import com.coderscampus.myapp.service.UserArrayService;

public class App {

	public static void main(String[] args) throws IOException {
		new App().execute();
	}

	private void execute() throws IOException {
		// Your code goes here, not in the main() method
		// This remoBennettA3 bennettA3 = new BennettA3()
		// The code below is to be deleted once you understand what it does

		User[] users = new UserArrayService().parseFile("data.txt");
		Scanner scan = new Scanner(System.in);
		int fails = 0;
		User foundUser = null;
		while (fails <= 5 && foundUser == null) {
			System.out.println("Enter a Username: ");
			String username = scan.nextLine();
			System.out.println("Enter a Password");
			String password = scan.nextLine();
			foundUser = validate(username, password, users);
			if (foundUser != null) {
				System.out.println("Welcome " + foundUser.getName());
			} else {
				fails++;
				if (fails == 5) {
					System.out.println("Too many failed login attemps, you are now locked out.");
					System.exit(fails);
				} else
					System.out.println("Invalid login, please try again.");
			}

		}
		scan.close();
	}

	private User validate(String username, String password, User[] users) {
		for (User user : users) {
			if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {

				return user;

			}
		}
		return null;
	}

}
