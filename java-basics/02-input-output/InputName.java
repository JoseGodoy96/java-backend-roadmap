/*
Exercise: Input and Output with Scanner

Goal:
Learn how to read user input from the terminal and print a response.

Instructions:
1. Import the necessary class to read input from the keyboard.
2. Inside the main method, create an object that allows reading from standard input.
3. Print a message asking the user to enter their name.
4. Read the line entered by the user and store it in a variable.
5. Print a greeting message that includes the name entered by the user.

Expected interaction example:

Enter your name: Chema
Hello Chema!

Concepts practiced:
- import statements
- user input from terminal
- variables
- strings
- concatenation
*/

import java.util.Scanner;

public class InputName {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Introduce tu nombre: ");
		String nombre = scanner.nextLine();

		System.out.println("Hola " + nombre);

		scanner.close();
	}
}