package algoCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {

	public static String inputLink = null;
	static ArrayList<Double> inputArray = null;
	static double sum = 0;
	static double maximum =0; 
	//C:\Users\hardi\Desktop\a.txt

	public static void main(String[] args) {
		inputArray = new ArrayList<Double>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the link of the file with filename:-");
		String inputFile = "C:\\Users\\hardi\\Desktop\\a.txt";
		try {
			scanner = new Scanner(new File(inputFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (scanner.hasNext()) {

			String[] inputData = scanner.next().split(";");
			for (int i = 0; i < inputData.length; i++) {
				inputArray.add(Double.parseDouble(inputData[i]));

			}
		}
		System.out.println(inputArray.toString());
		bruteForce(inputArray, inputArray.size());
 		System.out.println(maximum);
	}

	//brute force with n^3 complexity
	
//	public static double bruteForce(ArrayList<Double> input, int index)
//	{
//		
//		for(int sizeOfSubArray = 0; sizeOfSubArray<index;sizeOfSubArray++)
//		{
//			for(int indexOfArray = 0 ; indexOfArray < index ; indexOfArray++)
//			{
//				sum =0;
//				if(sizeOfSubArray+indexOfArray > index)
//					break;
//				for(int startingPoint = indexOfArray; startingPoint < indexOfArray+sizeOfSubArray;startingPoint++)
//				{
//					sum +=inputArray.get(startingPoint);
//				}
//				maximum = Math.max(maximum, sum);
//				
//			}
//		}
//		return maximum;
//	}
	
	
	//brute force with n^2 complexity
	public static double bruteForce(ArrayList<Double> input, int index)
	{
 		for(int indexOfArray = 0 ; indexOfArray < index;indexOfArray++)
		{
 
				sum = 0;
			for(int sizeOfArray = 1 ; sizeOfArray < index-indexOfArray;sizeOfArray++)
			{
					sum +=  inputArray.get(sizeOfArray-1);
					
			
					
					
					maximum = Math.max(maximum, sum);
					System.out.println(maximum);
 			}
		}
		return maximum;
	}
}
	

