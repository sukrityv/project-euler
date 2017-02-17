package com.euler.solutions.problem11to15;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Collatz sequence
 * Problem 1
 * The following iterative sequence is defined for the set of positive integers:
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Sukrity
 *
 */
public class Problem14_LongestCollatzSequence {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(getCollatzSequence(10));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	private static long getCollatzSequence(int limit) {

		Map<Long, Integer> chainLengths = new HashMap<Long, Integer>();
		long maxLength = 1;
		long number = 1;

		for (int i = 2; i < limit; i++) {
			int length = 1;
			long num = i;

			Map<Long, Integer> temp = new HashMap<Long, Integer>();

			while (num >= 1) {
				if (chainLengths.containsKey(num)) {
					length += chainLengths.get(num);
					break;
				}
				num = num % 2 == 0 ? num / 2 : 3 * num + 1;
				length++;
				temp.put(num, length);
			}
			chainLengths.put(num, length);
			if (length > maxLength) {
				maxLength = length;
				number = i;
			}
			for (long tempNum : temp.keySet()) {
				chainLengths.put(tempNum, length - temp.get(tempNum) + 1);
			}
		}
		System.out.println(number);

		return maxLength;
	}
}
