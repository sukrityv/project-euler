package com.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author versu12
 *
 */
public class Agarbatti {
	
	List<Integer> xcords = new ArrayList<Integer>();
	List<Integer> ycords = new ArrayList<Integer>();
	List<Integer> times = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		Agarbatti ag  = new Agarbatti();
		ag.easySetup();
		System.out.println(ag.execute(3));
	}
	
	public void easySetup(){
		xcords.add(1);
		xcords.add(4);
		xcords.add(2);
		xcords.add(5);
		xcords.add(7);
		
		ycords.add(2);
		ycords.add(5);
		ycords.add(3);
		ycords.add(6);
		ycords.add(8);
		
		times.add(1);
		times.add(6);
		times.add(15);
	}
	
	public String execute(int n){
		List<Integer> distances = new ArrayList<Integer>();
		
		for(int i=2; i<n+2; i++){
			int dist1 = distance(xcords.get(0),xcords.get(i),ycords.get(0),ycords.get(i));
			int dist2 = distance(xcords.get(1),xcords.get(i),ycords.get(1),ycords.get(i));
			
			distances.add(Math.max(dist1, dist2));
		}
		
		String result = "";
		for(int time: times){
			int count=0;
			for(int dist : distances){
				if(dist<=time){
					count++;
				}
			}
			result = result + count + " ";
		}
		
		return result.substring(0, result.length()-1);
	}

	//(x2-x1)^2 + (y2-y1)^2 -> root of this
	private int distance(int x1, int x2, int y1, int y2) {
		double calc = Math.pow(x2-x1,2) + Math.pow(y2-y1, 2);
		calc = Math.sqrt(calc);
		
		return (int) Math.ceil(calc);
	}
}
