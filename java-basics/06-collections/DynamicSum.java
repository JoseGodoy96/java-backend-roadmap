/*
Exercise: Dynamic Number List

Goal:
Learn to use ArrayList instead of fixed-size arrays.

Instructions:

1. Ask the user how many numbers they want to enter.
2. Create an ArrayList to store the numbers.
3. Read the numbers from the user.
4. Store them in the list.
5. Calculate the sum of all numbers.
6. Print the total.

Concepts practiced:
- ArrayList
- dynamic collections
- loops
- accumulation
*/

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicSum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Cuantos numeros vas a introducir? ");
		int total = sc.nextInt();

		ArrayList<Integer> numbers = new ArrayList<>();

		int i = 0;
		while (i < total) {
			System.out.print("Introduzca el numero: ");
			int num = sc.nextInt();
			numbers.add(num);
			i++;
		}

		System.out.println("Todos los numeros introducidos!");

		i = 0;
		int sum = 0;

		while (i < numbers.size()) {
			sum += numbers.get(i);
			i++;
		}

		System.out.println("La suma total es: " + sum);

		sc.close();
	}
}
