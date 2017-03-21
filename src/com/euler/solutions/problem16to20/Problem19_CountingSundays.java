package com.euler.solutions.problem16to20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Counting Sundays
 * Problem 19
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * 
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * 
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author sukrityv
 *
 */
public class Problem19_CountingSundays {

	public static void main(String[] args) throws ParseException {
		long startTime = System.currentTimeMillis();

		System.out.println(countSundays(1000));

		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}
	
	static long countSundays(int power) throws ParseException {
		int result = 0;

		int month = 1;
		int year = 1901;

		while (year <= 2000) {
			String date = "1/" + month++ + "/" + year;
			if (month == 13) {
				year++;
				month = 1;
			}
			
			Calendar c = Calendar.getInstance();
			c.setTime(new SimpleDateFormat("dd/M/yyyy").parse(date));
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			//System.out.println(date + " - " + dayOfWeek);
			if(dayOfWeek == 1){
				result++;
			}
		}
		
		return result;
	}

}
