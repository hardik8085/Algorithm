package algoCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.DoubleToLongFunction;

public class MyMergeSort {

	public static String inputLink = null;
	static ArrayList<Double> inputArray = null;

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
		MergeSort(inputArray);
		System.out.println(inputArray.toString());
	}

	public static void MergeSort(ArrayList<Double> input) {
		divide(0, input.size()-1);

	}

	 public static void divide(int startIndex,int endIndex){
         
	        //Divide till you breakdown your list to single element
	        if(startIndex<endIndex && (endIndex-startIndex)>=1){
	            int mid = (endIndex + startIndex)/2;
	            divide(startIndex, mid);
	            divide(mid+1, endIndex);        
	             
	            //merging Sorted array produce above into one sorted array
	            merger(startIndex,mid,endIndex);            
	        }       
	    }   
	     
	    public static void merger(int startIndex,int midIndex,int endIndex){
	     
	    ArrayList<Double> temp = new ArrayList<>();
	    int leftIndex = startIndex;
	    int rightIndex = midIndex+1;
	    
	    
	    
//	    while(leftIndex<=midIndex && rightIndex<=endIndex){
//            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
//                mergedSortedArray.add(inputArray.get(leftIndex));
//                leftIndex++;
//            }else{
//                mergedSortedArray.add(inputArray.get(rightIndex));
//                rightIndex++;
//            }
//        } 
	    
	    while(leftIndex<=midIndex && rightIndex<=endIndex){
	    	if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
	    		temp.add(inputArray.get(leftIndex));
	    		System.out.println(inputArray.get(leftIndex));
	    		leftIndex++;
	    	}
	    	else{
	    		System.out.println(inputArray.get(rightIndex));

	    		temp.add(inputArray.get(rightIndex));

	    		rightIndex++;
	    	}
	    }
	    	
	    while(leftIndex<=midIndex){
	    	temp.add(inputArray.get(leftIndex));
    		System.out.println(inputArray.get(leftIndex));

    		leftIndex++;
	    }
	    
	    while(rightIndex<=endIndex){
	    	temp.add(inputArray.get(rightIndex));
    		System.out.println(inputArray.get(rightIndex));

    		rightIndex++;
	    }
	    
	    int i=0;
	    int j=startIndex;
	    System.out.println(temp.toString());
	    while(i<temp.size()){
	    	inputArray.set(j, temp.get(i));
	    	i++;
	    	j++;
	    }
//	    int i = 0;
//        int j = startIndex;
//        //Setting sorted array to original one
//        while(i<mergedSortedArray.size()){
//            inputArray.set(j, mergedSortedArray.get(i++));
//            j++;
//        }
	    }
  
	    
	    //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
//	        ArrayList<Double> mergedSortedArray = new ArrayList<Double>();
//	         
//	        int leftIndex = startIndex;
//	        int rightIndex = midIndex+1;
//	         
//	        while(leftIndex<=midIndex && rightIndex<=endIndex){
//	            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
//	                mergedSortedArray.add(inputArray.get(leftIndex));
//	                leftIndex++;
//	            }else{
//	                mergedSortedArray.add(inputArray.get(rightIndex));
//	                rightIndex++;
//	            }
//	        }       
//	         
//	        //Either of below while loop will execute
//	        while(leftIndex<=midIndex){
//	            mergedSortedArray.add(inputArray.get(leftIndex));
//	            leftIndex++;
//	        }
//	         
//	        while(rightIndex<=endIndex){
//	            mergedSortedArray.add(inputArray.get(rightIndex));
//	            rightIndex++;
//	        }
//	         
//	        int i = 0;
//	        int j = startIndex;
//	        //Setting sorted array to original one
//	        while(i<mergedSortedArray.size()){
//	            inputArray.set(j, mergedSortedArray.get(i++));
//	            j++;
//	        }
//	    }
}
