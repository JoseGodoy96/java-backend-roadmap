/*
Exercise: Sum of an Array

Goal:
Practice working with arrays and loops.

Instructions:
1. Create an array of integers with 5 numbers.
2. Use a loop to iterate through the array.
3. Calculate the sum of all numbers in the array.
4. Print the final sum.

Example output:

Numbers: 2 4 6 8 10
Sum: 30

Concepts practiced:
- arrays
- loops
- accumulation variables
*/

import java.util.Scanner;

public class SumArray {

	public static void main(String[] argc) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];

		int	i = 0;
		while (i < num.length)
		{
			System.out.print("Introduzca un numero: ");
			int number = sc.nextInt();
			num[i] = number;
			i++;
		}

		System.out.print("recibidos todos los datos");
		
		i = 0;
		int total = 0;
		while (i < num.length)
		{
			total += num[i];
			i++;
		}

		System.out.println("La suma total es: " + total);

		sc.close();
	}
}