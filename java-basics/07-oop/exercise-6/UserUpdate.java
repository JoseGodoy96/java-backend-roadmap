/*
Exercise: Update User Age

Goal:
Practice updating objects inside a list.

Instructions:

1. Use the User class.

2. Ask the user how many users they want to enter.

3. Store all users in an ArrayList.

4. Ask for a name to update.

5. If the user exists:
	- Ask for the new age
	- Update the user's age

6. If not:
	- Print "User not found"

7. Print the updated list.

Concepts practiced:
- modifying objects
- searching
- CRUD operations
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserUpdate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<User> users = new ArrayList<>();

		System.out.print("Cuantos usuarios vas a introducir? ");
		int total = sc.nextInt();
		sc.nextLine();

		if (total == 0) {
			System.out.print("No hay usuarios");
			sc.close();
			return ;
		}

		while (total > 0)
		{
			System.out.print("Como se llama? ");
			String name = sc.nextLine();

			System.out.print("Cual es su edad? ");
			int age = sc.nextInt();
			sc.nextLine();

			users.add(new User(name, age));
			total--;
		}

		System.out.print("Como se llama el usuario que vas a modificar? ");
		String searchName = sc.nextLine().toLowerCase();

		int i = 0;
		boolean found = false;
		while (i < users.size())
		{
			String userSearch = users.get(i).name.toLowerCase();
			if (userSearch.equals(searchName)) {
				System.out.print("Cual es su nueva edad? ");
				int newage = sc.nextInt();
				sc.nextLine();
				users.get(i).age = newage;
				found = true;
			}
			i++;
		}

		if (!found) {
			System.out.print("no hay usuarios con ese nombre ");
			sc.close();
			return;
		}

		i = 0;
		while (i < users.size())
		{
			users.get(i).hello();
			i++;
		}
		sc.close();
	}
}
