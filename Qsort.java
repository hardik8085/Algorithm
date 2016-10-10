import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

 
public class Qsort {

	
	static Scanner inputLink = null;
	static Scanner inputLink1 = null;
	static Scanner inputLink2 = null;
	static int count = 0;
	static BufferedWriter writer = null;
	static ArrayList<Double> inputArray = null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		writer = new BufferedWriter (new FileWriter(".\\answers.txt"));

		inputArray= new ArrayList<Double>() ;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the link of the file with filename:-");
		String inputFile = scanner.nextLine();
		try {
			inputLink = new Scanner(new File(inputFile));
			 inputFile = scanner.nextLine();
			inputLink1 = new Scanner(new File(inputFile));
			
			 inputFile = scanner.nextLine();
			inputLink2 = new Scanner(new File(inputFile));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Convert the data from input text file to the double
		
		while(inputLink.hasNext())
		{
			
			String [] inputData = inputLink.next().split(";");
 			for(int i = 0; i<inputData.length;i++)
			{
 			//doubleInputData[count] 
				double a = Double.parseDouble(inputData[i]);
				inputArray.add(a);
 			count++;
			}
		}
		while(inputLink1.hasNext())
		{
			
			String [] inputData = inputLink1.next().split(";");
 			for(int i = 0; i<inputData.length;i++)
			{
 			//doubleInputData[count] 
				double a = Double.parseDouble(inputData[i]);
				inputArray.add(a);
 			count++;
			}
		}
		while(inputLink2.hasNext())
		{
			
			String [] inputData = inputLink2.next().split(";");
 			for(int i = 0; i<inputData.length;i++)
			{
 			//doubleInputData[count] 
				double a = Double.parseDouble(inputData[i]);
				inputArray.add(a);
 			count++;
			}
		}
		
		 //Represent unsorted and sorted data and its computation time
		System.out.println("Unsorted data"+inputArray.toString());
		double startTime = System.currentTimeMillis();

 	    sort(inputArray, 0, inputArray.size() - 1);
		double endTime = System.currentTimeMillis();

		System.out.println("sorted data"+inputArray.toString());
 		writer.write( "Number Of Element  "+ inputArray.size()+   "  Time  " + (endTime - startTime)+"\n");
		writer.newLine();

		//export txt file
		System.out.println("Refresh the workspace you will get the answer.txt file this file include the sorted file");
		writer.write(inputArray.toString());
		writer.close();


 		
	}
	
	//call of quick sort from main method
	public static void sort(List<Double> list, int from, int to) {
	    if (from < to) {
	        int pivot = from;
	        int left = from + 1;
	        int right = to;
	        double pivotValue = list.get(pivot);
	        while (left <= right) {
	            // left <= to -> limit protection
	            while (left <= to && pivotValue >= list.get(left)) {
	                left++;
	            }
	            // right > from -> limit protection
	            while (right > from && pivotValue < list.get(right)) {
	                right--;
	            }
	            if (left < right) {
	                Collections.swap(list, left, right);
	            }
	        }
	        Collections.swap(list, pivot, left - 1);
	        sort(list, from, right - 1); // <-- pivot was wront!
	        sort(list, right + 1, to);   // <-- pivot was wront!
	    }
	}
}
