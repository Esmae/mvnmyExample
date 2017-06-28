package com.test.mvnmyExample;

public class TriNum {

	public static void main(String[] args) {
		System.out.println(popArrayCount(11));
	}

	private static int popArrayCount(int size) {
		int[] myArray = new int[size];
		for(int i=0;i<size;i++){
			myArray[i]=i;
		}
		int count = 0;
		for(int i=0;i<size;i++){
			count = count + myArray[i];
		}
		return count;
	}

}
