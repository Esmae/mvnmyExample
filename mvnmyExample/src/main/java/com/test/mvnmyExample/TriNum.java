package com.test.mvnmyExample;
/**
 * Initialises array & sums numbers
 * uses static methods
 */

import test.java.com.test.mvnmyexample.TestSum;

public class TriNum {

	public static void main(String[] args) {
		if(args.length==1){
			try{
				int sizeOfArray = Integer.parseInt(args[0]); 
				if(sizeOfArray <= 0){
					System.out.println("Invalid Number: Enter a value greater than zero");
				}
				int cumCountNum = cumCount(popArray(sizeOfArray));
				System.out.println(cumCountNum);
				
				//testing the method
				TestSum theTest = new TestSum();
				boolean test = theTest.TestCumSum(cumCountNum, sizeOfArray);
				System.out.println(test);
				
			}catch(NumberFormatException e){
				System.out.println("Invalid String: Enter a number");
			}
		}
		;
	}

	public static int[] popArray(int size) {
		//initialising array
		int[] myArray = new int[size];
		for(int i=0;i<size;i++){
			myArray[i]=i;
		}
		return myArray;
	}
	
	public static int cumCount(int[] theArray){
		//Cumulative sum of numbers in array
		int size = theArray.length;
				int count = 0;
				for(int i=0;i<size;i++){
					count = count + theArray[i];
				}
				return count;
	}

}
