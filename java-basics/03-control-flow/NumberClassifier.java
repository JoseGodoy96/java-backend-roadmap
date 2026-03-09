/*
Exercise: Number Classifier

Goal:
Practice conditional statements using if, else if, and else.

Instructions:
1. Ask the user to enter an integer number.
2. Read the number from the terminal.
3. Determine whether the number is:

	- Positive
	- Negative
	- Zero

4. Print the corresponding message.

Example interactions:

Enter a number: 10
The number is positive

Enter a number: -3
The number is negative

Enter a number: 0
The number is zero

Concepts practiced:
- if statements
- else if
- comparison operators
- integer variables
*/

import java.util.Scanner;

public class NumberClassifier {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca un numero: ");
		int number = sc.nextInt();

		if (number == 0) {
			System.out.println("El numero es cero");
		} else if (number > 0) {
			System.out.println("El numero es positivo");
		} else {
			System.out.println("El numero es negativo");
		}
		
		sc.close();
	}
}
