package com.euler.solutions.problem16to20;

import java.math.BigDecimal;

/**
 * Factorial digit sum
 * Problem 20
 * n! means n × (n - 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * @author sukrityv
 *
 */
public class Problem20_FactorialDigitSum {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(factorialDigitSum(100));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long factorialDigitSum(int num) {
		long sum = 0;

		BigDecimal factorial = new BigDecimal(1);
		for (int i = num; i > 1; i--) {
			factorial = factorial.multiply(new BigDecimal(i));
		}

		String str = factorial.toString();
		System.out.println(str);

		for (Character temp : str.toCharArray()) {
			sum += Character.getNumericValue(temp);
		}

		return sum;
	}

}
