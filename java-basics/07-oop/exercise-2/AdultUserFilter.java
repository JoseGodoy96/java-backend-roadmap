/*
Exercise: Filter Adult Users

Goal:
Practice working with lists of objects and filtering data.

Instructions:

1. Use the User class created in the previous exercise.

2. In the main program:

	- Ask the user how many users they want to enter.
	- Create an ArrayList to store User objects.

3. For each user:
	- Ask for the name
	- Ask for the age
	- Create a new User object
	- Add it to the list

4. After all users are entered:

	- Print ONLY the users who are adults (age >= 18).

5. If there are no adult users, print:

	"No adult users found"

Example interaction:

How many users? 3

Enter name: Ana
Enter age: 15

Enter name: Carlos
Enter age: 22

Enter name: Marta
Enter age: 30

Adult users:

Carlos - 22
Marta - 30

Concepts practiced:
- ArrayList of objects
- object attribute access
- filtering data with conditions
- loops
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AdultUserFilter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<User> users = new ArrayList<>();

		System.out.print("Cuantos usuarios va a introducir? ");
		int total = sc.nextInt();

		while (total > 0) {
			System.out.print("Cual es su nombre? ");
			String name = sc.nextLine();

			System.out.print("Cual es su edad? ");
			int age = sc.nextInt();

			users.add(new User(name, age));

			total--;
		}

		int	i = 0;
		int count = 0;
		while (i < users.size())
		{
			if (users.get(i).age >= 18) {
				users.get(i).hello();
				count++;
			}
			i++;
		}
		if (count == 0) {
			System.out.println("No hay usuarios mayores de edad");
		}
		sc.close();
	}
}