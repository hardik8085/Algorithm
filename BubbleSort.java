package algoCode;

 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

import javax.swing.text.html.parser.ParserDelegator;

public class BubbleSort {

	//C:\Users\hardi\Desktop\a.txt
	static Scanner inputLink = null;
 	public static void main(String [] args)
	{
		ArrayList<Double> doubleInputData = new ArrayList<Double>() ;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the link of the file with filename:-");
		String inputFile = scanner.nextLine();
		try {
			inputLink = new Scanner(new File(inputFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(inputLink.hasNext())
		{
				
			String[] inputData =  inputLink.next().split(";");
			for(int i =0 ;i<inputData.length;i++)
			{
				doubleInputData.add(Double.parseDouble(inputData[i]));
				
			}
		}
		
		 //Bubble Sort algorithm
		
		
		for(int i=doubleInputData.size()-1;i>0;i--)
		{
			for(int j=i;j>0;j--)
			{
				if(doubleInputData.get(j-1)>doubleInputData.get(i))
				{
					 double temp = doubleInputData.get(j-1);
					doubleInputData.set(j-1,doubleInputData.get(i) );
					doubleInputData.set(i, temp);
				}
				System.out.println(doubleInputData.toString());

			}
		}
		
		System.out.println(doubleInputData.toString());
	}
	
	
}
