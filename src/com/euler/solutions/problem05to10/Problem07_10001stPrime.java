package com.euler.solutions.problem05to10;

import java.util.ArrayList;
import java.util.List;

/**
 * 10001st prime
 * Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 * 
 * @author sukrityv
 *
 */
public class Problem07_10001stPrime {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		int number = 10001;

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		
		int count = 1;
		int result = 0;
		
		for(int i=3; ; i+=2){
			boolean isPrime = true;
			
			for(int prime : primes){
				if(i%prime==0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				primes.add(i);
				if(++count == number){
					result = i;
					break;
				}
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		
		System.out.println(result);
	}
}
