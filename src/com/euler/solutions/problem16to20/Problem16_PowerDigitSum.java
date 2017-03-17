package com.euler.solutions.problem16to20;

import java.math.BigInteger;

/**
 * Power digit sum
 * Problem 16
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 21000?
 * @author sukrityv
 *
 */
public class Problem16_PowerDigitSum {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(powerDigitSum(1000));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long powerDigitSum(int power){
		long sum = 0;
		String str = BigInteger.valueOf(2).pow(power).toString();
		System.out.println(str);
		
		for(Character temp : str.toCharArray()){
			sum += Character.getNumericValue(temp);
		}
		
		return sum;
	}

}
