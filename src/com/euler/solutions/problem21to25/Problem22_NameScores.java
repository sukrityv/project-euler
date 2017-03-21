package com.euler.solutions.problem21to25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Names scores
 * Problem 22
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. 
 * Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author sukrityv
 *
 */
public class Problem22_NameScores {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		System.out.println(nameScores(10000));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long nameScores(int maxNum) throws IOException {

		String fileName = "src\\com\\euler\\solutions\\problem21to25\\names.txt";

		String[] str = null;
		List<String> names = new ArrayList<String>();

		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		while ((sCurrentLine = br.readLine()) != null) {
			str = sCurrentLine.split(",");
		}

		for (String temp : str) {
			if (temp != null) {
				temp.replaceAll("\"", "");
				names.add(temp);
			}
		}

		Collections.sort(names);

		//System.out.println(names);
		long result = 0;

		int position = 1;
		for (String name : names) {
			name = name.replaceAll("\"", "").trim();
			if(name == null || "".equals(name)){
				continue;
			}
			
			int value = 0;
			
			//System.out.println(name);
			for (int i = 0; i < name.length() ; i++) {
			      value += (int)name.charAt(i) - 64;
			}
			
			result += value * position;
			
			position++;
		}

		return result;
	}

}
