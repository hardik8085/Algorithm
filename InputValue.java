package algoCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

public class InputValue {

	public static String inputLink = null;
	static ArrayList<Double> inputArray = new ArrayList<Double>();;
	
	public static void  main(String[] args) {
		
		InputValue i = new InputValue();
		ArrayList<Double> temp = i.giveInput();
		System.out.println(temp);
 		
		 
	}
	public  ArrayList<Double> giveInput()
	{
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
		
		return inputArray;
	}
}
