package com.test.mvnmyExample;

public class TestSum {
	private int[] refArray = {0,1,6,10,15,21,28,36,45,55,66,78,91,105}; //14 numbers, including zero
	
	public boolean TestCumSum(int CumSum, int sizeOfArray){//only works if sizeOfArray <=14, otherwise will return 
		if(refArray[sizeOfArray-1]==CumSum){				// false by default
			return true;
		}
		else return false;
	}
}
