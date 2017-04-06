package com.euler.solutions.problem21to25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * Lexicographic permutations Problem 24 A permutation is an ordered arrangement
 * of objects. For example, 3124 is one possible permutation of the digits 1, 2,
 * 3 and 4. If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2
 * are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * @author sukrityv
 *
 */
public class Problem24_LexicographicPermutations {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		getFactorials();
		
		String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};  
		List<String> chars = new ArrayList<String>(Arrays.asList(array));
		
		calculate(1000000-1, chars);

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

	public static Map<Integer, Long> factorials = new HashMap<Integer, Long>();
	
	public static void getFactorials(){
		for(int i=9; i>=1; i--){
			long factorial = 1;
			int num = i;
			while(num>=1){
				factorial *= num;
				num--;
			}
			factorials.put(i, factorial);
		}
		//System.out.println(factorials);
	}
	
	public static void calculate(long index, List<String> chars) {
		String digits = "";
		Long totalNums = 0l;

		for (int i = chars.size()-1; i >= 1; i--) {
			int count = 0;
			while (index > totalNums) {
				totalNums += factorials.get(i);
				count++;
			}
			if(index < totalNums){
				totalNums -= factorials.get(i);
				digits += chars.remove(--count);
			} else {
				digits += chars.remove(count);
				break;
			}
		}
		
		for(String temp : chars){
			digits += temp;
		}
		
		System.out.println(digits);
	}
}
