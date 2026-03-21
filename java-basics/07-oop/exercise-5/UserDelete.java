/*
Exercise: Delete User by Name

Goal:
Practice removing elements from a list of objects.

Instructions:

1. Use the User class.

2. Ask the user how many users they want to enter.

3. Store all users in an ArrayList.

4. Ask the user for a name to delete.

5. Search the list:

	- If a user with that name exists → remove it from the list
	- If not → print "User not found"

6. After the operation:

	- Print the updated list of users

Example:

Users:
Ana 20
Carlos 30
Marta 25

Delete: Carlos

Result:
Ana - 20
Marta - 25

Concepts practiced:
- removing elements from ArrayList
- searching in collections
- loops
- object comparison
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class UserDelete {

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

		System.out.print("Como se llama el usuario que vas a borrar? ");
		String searchName = sc.nextLine().toLowerCase();

		int i = 0;
		boolean found = false;
		while (i < users.size())
		{
			String userSearch = users.get(i).name.toLowerCase();
			if (userSearch.equals(searchName)) {
				users.remove(i);
				found = true;
			} else {
				i++;
			}
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
