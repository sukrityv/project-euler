package com.euler.solutions.problem11to15;

/**
 * Highly divisible triangular number
 * Problem 12
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * Let us list the factors of the first seven triangle numbers:
 *
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 * 
 * What is the value of the first triangle number to have over five hundred divisors?
 * 
 * @author sukrityv
 *
 */
public class Problem12_HighlyDivisibleTriangle {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(getTriangleNumber(500));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	static long getTriangleNumber(int limit) {
		for (int i = 1;; i++) {
			long triNum = (i * (i + 1)) / 2;
			int divisorCount = 0;

			for (int j = 1; j <= Math.sqrt(triNum); j++) {
				if (triNum % j == 0) {
					divisorCount++;
				}
				if (2 * divisorCount > limit) {
					return triNum;
				}
			}
		}
	}

}
