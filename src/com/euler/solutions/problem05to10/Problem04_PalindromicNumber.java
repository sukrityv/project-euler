package com.euler.solutions.problem05to10;

/**
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author Sukrity
 *
 */
public class Problem04_PalindromicNumber {
		
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(getPalindrom());
	
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long getPalindrom(){
		int result = 1;
		int temp = 1;
		boolean isPalindrom;
		int limit = 100;
		
		char[] numStr = new char[6];
		
		for(int i=999; i>=limit; i--){
			for(int j=999; j>100; j--){
				temp = i * j;
				isPalindrom = true;
				
				numStr= String.valueOf(temp).toCharArray();
				for(int p=0, q=numStr.length-1; p<q; p++, q--){
					if(numStr[p]!=numStr[q]){
						isPalindrom = false;
						break;
					}
				}
				if(isPalindrom){
					limit = j > limit ? j : limit;
					System.out.println(i + "," + j + "," + temp);
					break;
				}
			}
			if(temp > result){
				result = temp;
			}
		}
		return result;
	}

}
