package com.euler.solutions.problem16to20;

import java.util.HashMap;

/**
 * Number letter counts
 * Problem 17
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. 
 * For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
 * The use of "and" when writing out numbers is in compliance with British usage.
 * 
 * @author sukrityv
 *
 */
public class Problem17_NumberLetterCounts {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		try {
			System.out.println(numberLetterCount(1000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static HashMap<Integer, Integer> letters = new HashMap<Integer, Integer>();
	
	static void populateLettersMap(){
		letters.put(1, "one".length());
		letters.put(2, "two".length());
		letters.put(3, "three".length());
		letters.put(4, "four".length());
		letters.put(5, "five".length());
		letters.put(6, "six".length());
		letters.put(7, "seven".length());
		letters.put(8, "eight".length());
		letters.put(9, "nine".length()); 
		letters.put(10, "ten".length());
		letters.put(11, "eleven".length());
		letters.put(12, "twelve".length());
		letters.put(13, "thirteen".length());
		letters.put(14, "fourteen".length());
		letters.put(15, "fifteen".length());
		letters.put(16, "sixteen".length());
		letters.put(17, "seventeen".length());
		letters.put(18, "eighteen".length());
		letters.put(19, "nineteen".length());
		letters.put(20, "twenty".length());
		letters.put(30, "thirty".length());
		letters.put(40, "forty".length());
		letters.put(50, "fifty".length());
		letters.put(60, "sixty".length());
		letters.put(70, "seventy".length());
		letters.put(80, "eighty".length());
		letters.put(90, "ninety".length());
		letters.put(100, "hundred".length());
	}
	
	static long numberLetterCount(int limit) throws Exception {

		long result = 0;
		populateLettersMap();

		for (int i = 1; i <= limit; i++) {

			int length = String.valueOf(i).length();
			int sum = 0;

			//System.out.println(i);

			// reversing the number string to make processing easier
			char[] digits = new char[4];
			for (int j = length - 1, k = 0; j >= 0; j--) {
				digits[k++] = String.valueOf(i).charAt(j);
			}
			
			int ones = Character.getNumericValue(digits[0]);
			int tens = length > 1 ? Character.getNumericValue(digits[1]) : 0;
			int hundreds = length == 3 ? Character.getNumericValue(digits[2]) : 0;
			
			// Handling of all scenarios for 2 digits (ones and tens)
			if (tens == 0) {
				if (ones > 0) {
					sum += letters.get(ones); //for eg like 1, 2, 5, 101, 205 etc 
				}
			} else if (tens == 1) {
				int teen = Integer.parseInt("" + digits[1] + digits[0]);
				sum += letters.get(teen);
			} else {
				sum += letters.get(tens * 10) + (ones > 0 ? letters.get(ones) : 0);
			}

			// Handling of 3 digit numbers
			if (length == 3) {
				sum += sum > 0 ? "and".length() : 0;
				sum += letters.get(hundreds) + letters.get(100);
			}

			//we only have 1 possible 4-digit value - 1000.
			if (length == 4) {
				sum += "onethousand".length();
			}

			result += sum;
		}

		return result;
	}

}
