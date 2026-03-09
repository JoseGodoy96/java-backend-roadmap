/*
Exercise: Age checker

Goal:
Practice conditional statements.

Instructions:
1. Ask the user for their age.
2. Read the age as an integer.
3. If the age is 18 or greater print:

	"You are an adult"

4. Otherwise print:

	"You are a minor"

Example:

Enter your age: 20
You are an adult
*/

import java.util.Scanner;

public class AgeChecker {
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		System.out.print("Que edad tienes? ");
		int age = sc.nextInt();

		if (age >= 18) {
			System.out.println("Eres mayor de edad");
		}
		else {
			System.out.println("Eres menor de edad");
		}

		sc.close();
	} 
}
