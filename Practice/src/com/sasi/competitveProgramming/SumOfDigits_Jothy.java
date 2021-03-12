package com.sasi.competitveProgramming;

import java.util.Scanner;

public class SumOfDigits_Jothy {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = scan.nextInt();

		System.out.println(sumOfDigits(num));

	}

	private static int sumOfDigits(int num) {
		int sum = 0;
		int number = num;
		while (num > 0 && num < 500) {
			sum = sum + num % 10;
			// System.out.println(sum);
			num = num / 10;
		}
		int twiceSum = sum * 2;
		int num2 = number + 1;
		int sum2 = 0;
		while (num2 > 0) {
			int temp = num2;
			sum2 = 0;
			while (temp > 0) {
				sum2 += temp % 10;
				if (sum2 == twiceSum) {
					return num2;
				}
				temp = temp / 10;
			}
			num2++;
		}
		return 0;
	}

}
