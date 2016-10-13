package algoCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.math.*;

public class HeapSort {
	static Scanner inputLink = null;
	static int count = 0;
	static ArrayList<Double> doubleInputData;
	static ArrayList<Double> sortedArray;
	// C:\Users\hardi\Desktop\a.txt

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doubleInputData = new ArrayList<Double>();
		sortedArray = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the link of the file with filename:-");
		String inputFile = "C:\\Users\\hardi\\Desktop\\a.txt";
		try {
			inputLink = new Scanner(new File(inputFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Convert the data from input text file to the double

		while (inputLink.hasNext()) {

			String[] inputData = inputLink.next().split(";");
			for (int i = 0; i < inputData.length; i++) {
				// doubleInputData[count]
				double a = Double.parseDouble(inputData[i]);
				doubleInputData.add(a);
				count++;
			}
		}
		System.out.println("Unsorted Input:-" + doubleInputData.toString());
		int i = (int) Math.floor(doubleInputData.size() - 1 / 2);

		int count = 0;
		 if(i%2 ==0){
			count = i/2;
		 }else{
			 count = i/2+1;
		 }

		for ( ; count >= 0; count--) {
			System.out.println("count value in loop"+count);
 			fulfillmaxhipify(count);
 		}

		int size = doubleInputData.size()-1;
		for(int j =0;j<=size;j++){
     	System.out.println("final output:-" + sortedArray.toString());
			sortedArray.add(doubleInputData.get(0));
			doubleInputData.set(0,doubleInputData.get(doubleInputData.size()-1));
 			System.out.println("size befor for loop"+doubleInputData.size());
			for(int k =size;k>=0;k--){
				System.out.println("size from the side of sending "+doubleInputData.size());
 				System.out.println("hipify  on"+ k);
 				fulfillmaxhipify(k);
 			}

		}
	System.out.println("final output:-" + sortedArray.toString());
		System.out.println("Sorted Output:-" + doubleInputData.toString());

	}
	
	public static void fulfillmaxhipify(int i){
		
		
 		int rootNode = i;
		int leftNode = (2*i)+1;
		int rightNode = (2*i)+2;
		System.out.println("LeftNode"+leftNode);
		System.out.println();
		if(leftNode>doubleInputData.size()-1){
			return;
		}
		double rootValue = doubleInputData.get(i);
		double leftValue = doubleInputData.get(leftNode);
		System.out.println("leftNode"+leftNode +"LeftValue"+ leftValue);

		if(rightNode <= doubleInputData.size()-1){
			System.out.println("leftnode value in right node"+ leftValue);
			double rightValue = doubleInputData.get(rightNode);
			if(rootValue < leftValue && rootValue < rightValue){
				if(leftValue> rightValue){
					swap(leftNode,rootNode);
				}
				else{
					swap(rightNode,rootNode);
				}
			}else if(rootValue< leftValue){
				swap(leftNode,rootNode);
			}
			else if(rootValue < rightValue){
				swap(rightNode,rootNode);

			}
		}else if(leftNode <= doubleInputData.size()-1){
			swap(leftNode,rootNode);
 						
		} 
		
		
	}
	
	public static void swap(int one , int two){
		System.out.println(doubleInputData.get(one)+" "+ doubleInputData.get(two));
	double temp = doubleInputData.get(one);
	doubleInputData.set(one,doubleInputData.get(two));
	doubleInputData.set(two,temp);
	}

}