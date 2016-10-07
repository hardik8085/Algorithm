package algoCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Kadane {
	public static String inputLink = null;
	static ArrayList<Double> inputArray = null;
	static double sum = 0;
	static double maximum =0; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
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
		kadane(inputArray, inputArray.size());
 		System.out.println(maximum );
	}
	
	public static double kadane(ArrayList<Double> input, int index){
		for(int i =0;i<inputArray.size();i++){
			sum += inputArray.get(i);
			if(sum < 0){
				sum =0;
 			}
			else{
				if(Math.max(maximum, sum) == sum){
					maximum = sum;

				}
				System.out.println(maximum);

			}
		}
		return maximum;
	}

}
