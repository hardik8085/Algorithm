import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayLeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int output[] = new int [n];
        int numberOfRotation = k % n;
         for (int i =0 ;i < n;i++){
            if(i-numberOfRotation < 0){
                int first = (i-numberOfRotation)+n;
                int second = i;
                   output[first]=a[i];
                 
            }
            else{
                int first = (i-numberOfRotation);
                int second = i;
                    output[first]=a[i];

                
            }
        
         }
        return output;
    }
    
    
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of element in the array");
        int n = in.nextInt();
        System.out.println("Enter the rotation for the array");
        int k = in.nextInt();
        int a[] = new int[n];
        System.out.println("Enter "+n+" number for array press enter for new number");
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        System.out.println("After Rotation");
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
       
    }
    
     
}
