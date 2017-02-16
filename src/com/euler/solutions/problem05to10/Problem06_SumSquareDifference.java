package com.euler.solutions.problem05to10;

/**
 * Sum square difference
 * Problem 6
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author sukrityv
 *
 */
public class Problem06_SumSquareDifference {

	public static void main(String[] args) {
		
		long num = 100;
		
		//Sum of n natural numbers: n * (n + 1) * (1/2)
		long sumOfN = (num * (num + 1))/2;
		long sqOfSum = sumOfN * sumOfN;
		
		//Sum of square of n natural numbers: n * (n + 1) * (2n + 1) * (1/6)
		long sumOfSq = (num * (num + 1) * (2 * num + 1))/6;
		
		System.out.println("Sum of N = " + sumOfN);
		System.out.println("Sq of Sum of N = " + sqOfSum);
		System.out.println("Sum of Sqs of N = " + sumOfSq);
		
		System.out.println("Diffenrence = " + (sqOfSum - sumOfSq));
	}
}
