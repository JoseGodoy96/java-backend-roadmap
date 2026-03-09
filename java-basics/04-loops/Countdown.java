/*
Exercise: Countdown

Goal:
Practice loops in Java.

Instructions:
1. Ask the user to enter a number.
2. Use a loop to count down from that number to 0.
3. Print each number on a new line.

Example interaction:

Enter a number: 5

5
4
3
2
1
0

Concepts practiced:
- loops
- decrement
- integer variables
*/

import java.util.Scanner;

public class Countdown {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca un numero positivo: ");
		int number = sc.nextInt();

		if (number < 0) {
			System.out.println("El numero debe de ser positivo");
		} else {
			while (number >= 0) {
				System.out.println(number);
				number--;
			}
		}

		sc.close();
	}
}
