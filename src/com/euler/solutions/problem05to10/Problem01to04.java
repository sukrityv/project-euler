package com.euler.solutions.problem05to10;

import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;

public class Problem01to04 {
		
	public static void main(String[] args) {
		Problem01to04 s = new Problem01to04();
		
		System.out.println("1. " + s.problem1());
		System.out.println("2. " + s.problem2());
		System.out.println("3. " + s.problem3Faster());
		//System.out.println("4. " + s.problem4());
		
	}

	/**
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 * @return
	 */
	int problem1(){
		int sum = 0;
		for (int i=3; i<1000; i++){
			if(i%3==0 || i%5==0){
				sum +=i;
			}
		}
		return sum;
	}
	
	/**
	 * sum of the even-valued Fibonacci sequence whose values do not exceed four million
	 * @return
	 */
	int problem2(){
		int num1 = 1, num2 = 1, sum = 0;
		
		while(num2 < 4000000){
			num2 = num1 + num2;
			num1 = num2 - num1;
			
			if(num2%2== 0){
				sum += num2;
			}
		}
		return sum;
	}
	
	/**
	 * largest prime factor of the number 600851475143
	 * @return
	 */
	long problem3(){
		long startTime = System.currentTimeMillis();
		List<Long> primes = new ArrayList<Long>();
		primes.add(2l);
		
		boolean isPrime = false;
		
		long result=600851475143l;
		long maxLimit = 600851475143l;
				
		for(long j=3; j<maxLimit/j; j+=2l){
			isPrime = true;
			for(long num : primes){
				if(j%num==0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(j);
				if(600851475143l%j==0){
					result = j;
				}
			}
		}
		long endTime = System.currentTimeMillis();

		System.out.println("TotalTimeTaken = " + (endTime - startTime)/100);
		
		return result;
	}
	
	/**
	 * largest prime factor of the number 600851475143
	 * @return
	 */
	long problem3Faster(){
		long result=0l;
		long limit = 600851475143l;
		
		while(limit%2==0 && limit!=1){
			limit = limit/2;
			result = 2;
		}
				
		for(long i=3; i<=limit; i+=2l){
			while(limit%i == 0 && limit != 1){
				limit = limit/i;
				result = i;
			}
		}
		return result;
	}
}
