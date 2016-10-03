package algoCode;

 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

	static Scanner inputLink = null;

	public static void main(String[] args)
	{
		//C:\Users\hardi\Desktop\a.txt
	 	 
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
			
			
			//Insertion sort
			int temp = 0;

			for(int i=0;i<doubleInputData.size()-1;i++)
			{
				temp =i;
				for(int j=i;j<doubleInputData.size()-1;j++)
				{
					
					if(doubleInputData.get(temp)>doubleInputData.get(j+1))//if we use (doubleInputData.get(temp)<doubleInputData.get(j+1) then it works fine for all the numeber but it will not work if last number is smaller then second last number.
					{
						System.out.println(doubleInputData.get(j)+""+doubleInputData.get(j+1));
 						temp = j+1;
					}
					
					
				}
				System.out.println(doubleInputData.get(temp));
				double tempValue = doubleInputData.get(i);
				doubleInputData.set(i, doubleInputData.get(temp));
				doubleInputData.set(temp,tempValue );
				System.out.println(doubleInputData.toString());
			}
			System.out.println(doubleInputData.toString());

	}
}
