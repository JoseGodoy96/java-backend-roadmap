/*
Exercise: Find the Oldest User

Goal:
Practice iterating over objects and finding a maximum value.

Instructions:

1. Use the User class.

2. Ask the user how many users they want to enter.

3. Store all users in an ArrayList.

4. After all users are entered:

	- Find the user with the highest age.

5. Print:

	"Oldest user: NAME - AGE"

Example:

How many users? 3

Ana 20
Carlos 35
Marta 28

Oldest user: Carlos - 35

Concepts practiced:
- ArrayList of objects
- comparison
- tracking a maximum value
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class OldestUserFinder {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<User> users = new ArrayList<>();

		System.out.print("Cuantos usuarios va a introducir? ");
		int total = sc.nextInt();
		sc.nextLine();

		while (total > 0) {
			System.out.print("Como se llama? ");
			String name = sc.nextLine();

			System.out.print("Cual es su edad?  ");
			int age = sc.nextInt();
			sc.nextLine();

			users.add(new User(name, age));

			total--;
		}

		if (users.size() == 0) {
			System.out.println("No hay usuarios");
			sc.close();
			return ;
		}

		int	i = 0;
		User older = users.get(0);
		while (i < users.size()) {
			if (users.get(i).age > older.age)
				older = users.get(i);
			i++;
		}

		System.out.print("El usuario mayor es: ");
		older.hello();

		sc.close();
	}
}
