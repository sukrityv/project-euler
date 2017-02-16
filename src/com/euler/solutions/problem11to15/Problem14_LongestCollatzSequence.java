package com.euler.solutions.problem11to15;

import java.util.ArrayList;
import java.util.List;

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
		
		System.out.println(getCollatzSequence());
	
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	private static int getCollatzSequence() {
		
		int starting = 1000000;
		List<Integer> chain = new ArrayList<Integer>();
		chain.add(starting);
		
		//Populate 1st chain
		int num = starting - 1;
		int count=0;
		while(num>=1){
			if(num%2==0){
				num = num/2;
			} else {
				num = 3 * num + 1;
			}
			count++;
		}
		System.out.println(count);
		
		/*int length = chain.size();
		int result = starting;
		
		for(int i=starting-2; i > starting/2; i--){
			int count = 0;
			
			while(num>=1){
				if(chain.contains(num)){
					count += chain.size() - chain.indexOf(num) + 1;
					break;
				}
				if(num%2==0){
					num = num/2;
				} else {
					num = 3 * num + 1;
				}
				count++;
			}
			if(count > length){
				result = i;
			}
		}*/
		
		return 0;
	}
}
