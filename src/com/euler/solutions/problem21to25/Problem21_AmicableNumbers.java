package com.euler.solutions.problem21to25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Amicable numbers 
 * Problem 21 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n). 
 * If d(a) = b and d(b) = * a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author sukrityv
 *
 */
public class Problem21_AmicableNumbers {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(amicableNumbers(10000));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long amicableNumbers(int maxNum) {
		HashMap<Long, Long> divisorSums = new HashMap<Long, Long>();
		Set<Long> amicableNumbers = new HashSet<Long>();

		for (long i = 2; i < maxNum; i++) {
			long sum = 0;

			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}

			if (divisorSums.containsKey(sum) && divisorSums.get(sum) == i) {
				amicableNumbers.add(sum);
				amicableNumbers.add(i);
			} else {
				divisorSums.put(i, sum);
			}
		}

		long result = 0;
		for (Long number : amicableNumbers) {
			result += number;
			// System.out.println(number + " - " + divisorSums.get(number));
		}
		return result;
	}

}
