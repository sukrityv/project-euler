package com.euler.solutions.problem21to25;

import java.math.BigInteger;

/**
 * 1000-digit Fibonacci number
 * Problem 25
 * The Fibonacci sequence is defined by the recurrence relation:
 * 
 * Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * @author sukrityv
 *
 */
public class Problem25_1000DigitFibonacciNumber {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(fibonacciNum(1000));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long fibonacciNum(int length){
		int index = 12;
		
		BigInteger prev = BigInteger.valueOf(89);
		BigInteger num = BigInteger.valueOf(144);

		while(true){
			index++;
			num = num.add(prev);
			prev = num.subtract(prev);
			
			if(num.toString().length() == length){
				return index;
			}
		}
	}

}
