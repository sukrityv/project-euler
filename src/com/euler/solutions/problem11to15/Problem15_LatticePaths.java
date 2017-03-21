package com.euler.solutions.problem11to15;

/**
 * Lattice paths
 * Problem 15
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * @author sukrityv
 *
 */
public class Problem15_LatticePaths {

	public static long COUNT = 0;
	public static int SIZE = 0;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		SIZE = 20;
		traverse(0, 0);

		System.out.println(COUNT);

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");	//1140461 ms (20mins)
	}

	//Recursion gives really bad performance, but i couldn't understand the non-recursive solutions.
	private static void traverse(int i, int j) {
		if(i + j == SIZE + SIZE){
			COUNT++;
			return;
		}
		
		if(i < SIZE){
			traverse(i + 1, j);
		}
		if(j < SIZE){
			traverse(i, j + 1);
		}
	}

}
