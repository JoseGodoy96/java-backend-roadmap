/*
Exercise: User Manager

Goal:
Practice creating and using classes (objects) in Java.

Instructions:

1. Create a class called User.
2. The User class must have two attributes:
	- name (String)
	- age (int)

3. Create a constructor that initializes both attributes.

4. In the main program:

	- Ask the user how many users they want to enter.
	- Create an ArrayList to store User objects.
	- For each user:
        - Ask for the name
        - Ask for the age
        - Create a new User object
        - Add it to the list

5. After all users are entered:

	- Print all users stored in the list.

Example interaction:

How many users? 2

Enter name: Ana
Enter age: 25

Enter name: Carlos
Enter age: 30

Users entered:

Ana - 25
Carlos - 30

Concepts practiced:
- classes
- objects
- constructors
- ArrayList of objects
- object attributes
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Usermanager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<User> usuarios = new ArrayList<>();

		System.out.print("Cuantos usuarios vas a introducir? ");
		int num = sc.nextInt();
		sc.nextLine();

		while (num > 0)
		{
			System.out.print("nombre del usuario? ");
			String name = sc.nextLine();

			System.out.print("edad del usuario? ");
			int age = sc.nextInt();
			sc.nextLine();

			usuarios.add(new User(name, age));

			num--;
		}

		int	i = 0;
		while (i < usuarios.size()) {
			usuarios.get(i).hello();
			i++;
		}

		sc.close();
	}
}