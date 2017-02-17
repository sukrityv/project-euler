package com.euler.solutions.problem05to10;

/**
 * Special Pythagorean triplet
 * Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author sukrityv
 *
 */
public class Problem9_SpecialPythagoreanTriplet {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(getTriplet(1000));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	static long getTriplet(int sum) {
		for (int a = 1; a < 1000; a++) {
			int num1 = a * a;
			for (int b = a + 1; b < 1000; b++) {
				int num2 = b * b;
				double c = Math.sqrt(num1 + num2);
				if (c % 1 == 0 && (a + b + (long)c) == sum) {
					return a * b * (long) c;
				}
			}
		}
		return 0;
	}
	
	
}
