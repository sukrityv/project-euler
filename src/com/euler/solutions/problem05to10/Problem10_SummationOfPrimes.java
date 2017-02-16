package com.euler.solutions.problem05to10;

import java.util.ArrayList;
import java.util.List;

/**
 * Summation of primes
 * Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author Sukrity
 *
 */
public class Problem10_SummationOfPrimes {

	public static void main(String[] args) {
		System.out.println(getPrimesSum(2000000l));
	}
	
	static long getPrimesSum(long limit){
		long startTime = System.currentTimeMillis();

		List<Long> primes = new ArrayList<Long>();
		primes.add(2l);
		
		long sum = 2;
		boolean isPrime;
		
		for(long j=3; j<limit; j+=2l){
			isPrime = true;
			for(long num : primes){
				if(j%num==0){
					isPrime = false;
					break;
				}
				if(num>Math.sqrt(j)){
					//isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(j);
				sum += j;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("TotalTimeTaken = " + (endTime - startTime));
		
		return sum;
	}
	
}
