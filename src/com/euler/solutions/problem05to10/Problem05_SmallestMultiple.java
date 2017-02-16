package com.euler.solutions.problem05to10;

import java.util.HashMap;
import java.util.Map;

/**
 * Smallest multiple
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author sukrityv
 *
 */
public class Problem05_SmallestMultiple {

	public static void main(String[] args) {
		System.out.println(getSmallestMultiple(20));
	}

	private static int getSmallestMultiple(int limit) {
		
		long startTime = System.currentTimeMillis();

		//Map of all prime numbers within the limit with the number of occurences.
		Map<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
		
		for(int i=2; i<=limit; i++){
			//System.out.println(i);
			
			//List of all factors for i
			Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
			
			int num = i;
			
			//Number of time i is divisible by 2
			int count = 0;
			while(num%2==0 && num>=2){
				num = num/2;
				count++;
			}
			if(count!=0){
				temp.put(2, count);
			}
			
			//Finding the number of times i is divisible by other primes and adding it to temp map
			for(int j=3; j<i; j+=2){
				count = 0;
				while(num%j==0){
					num = num/j;
					count++;
				}
				if(count != 0){
					temp.put(j, count);
				}
			}
			
			//In case i is prime so does'nt have any other factors
			if(temp.isEmpty()){
				temp.put(num, 1);
			}
			
			//System.out.println(temp);
			
			//Updating the main map of all prime numbers
			for(int key : temp.keySet()){
				int totalCount = temp.get(key);
				if (primeFactors.get(key) == null || totalCount > primeFactors.get(key)){
					primeFactors.put(key, totalCount);
				}
			}
		}
		
		System.out.println(primeFactors);
		
		//Getting the smallest multiple
		int multiple = 1;
		for(int prime: primeFactors.keySet()){
			multiple = multiple * (int) Math.pow(prime, primeFactors.get(prime));
		}
		
		/*
		 * Brute force. Slower.
		 * 
		int multiple = 1;
		boolean flag;
		
		for(int i=20; ;i++){
			flag = true;
			for(int j=2; j<=20; j++){
				if(i%j != 0){
					flag = false;
					break;
				}
			}
			if(!flag){
				continue;
			}
			multiple = i;
			break;
		}*/

		long endTime = System.currentTimeMillis();

		System.out.println("That took " + (endTime - startTime) + " milliseconds");
		
		return multiple;
	}
}
