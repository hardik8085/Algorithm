import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Input;

public class IBMHashSet {

	static ArrayList<String> answer;
	static HashMap hashMap;
	static ArrayList<String> firstArraylist;
	static ArrayList<String> secondArrayList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// anal-->kaivalya kaivalya-->nishit kaivalya-->divyen nishit-->harry divyen-->rumit rumit-->shrujan rumit-->pritam rumit-->shashank

		System.out.println("Please enter Boss-->Employee data separated by blank space");
		 
		String input;
		Scanner scanner = new Scanner(System.in);
		hashMap = new HashMap<>();
		input = scanner.nextLine();
		answer = new ArrayList<>();
		 
		String[] firstInputArray = input.split(" ");
		System.out.println(firstInputArray.length);
		for (int i = 0; i < firstInputArray.length; i++) {
			String[] inputArray = firstInputArray[i].split("-->");
			hashMap.put(inputArray[1], inputArray[0]);
		}

 		System.out.println("Enter the name of First Employee");
		String first = scanner.next();
		System.out.println("Enter the name of the second Employee");
		String second = scanner.next();

		firstArraylist = new ArrayList<>();
		findBoss(first, firstArraylist);

		secondArrayList = new ArrayList<>();
		findBoss(second, secondArrayList);

		System.out.println(firstArraylist.toString());

		System.out.println(secondArrayList.toString());

		boolean flag = false;
		for (int i = 0; i < firstArraylist.size(); i++) {
			for (int j = 0; j < secondArrayList.size(); j++) {
				if (firstArraylist.get(i).equals(secondArrayList.get(j))) {
					System.out.println("Contact "+firstArraylist.get(i)+"To solve the issue between "+first+"and"+second);
					flag = true;
					break;
				}
				if (flag) {
					break;
				}
			}
		}
		
		if(!flag){
			System.out.println("No one is available to solve this issue");
		}

	}

	public static void findBoss(String employee, ArrayList<String> answer) {
		if (hashMap.get(employee) != null) {
			answer.add((String) hashMap.get(employee));
			findBoss((String) (hashMap.get(employee)), answer);

		}
	}

}
