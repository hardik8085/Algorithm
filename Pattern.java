import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the number of line in the code");
		Scanner scanner = new Scanner(System.in);

		int input = scanner.nextInt();

		System.out.println("Pattern A");

		for (int i = 0; i < input; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j + 1);
			}
			System.out.println();
		}

		System.out.println("Pattern B");

		for (int i = input; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(j + 1);
			}
			System.out.println();
		}
		
		
		
		
		System.out.println("Pattern C");


		for (int i = 0; i < input; i++) {
			for (int j = i; j >=0; j--) {
				System.out.print(j + 1);
			}
			System.out.println();
		}
		
		System.out.println("Pattern D");

		for (int i = input; i > 0; i--) {
			for (int j = i; j>0; j--) {
				System.out.print(j );
			}
			System.out.println();
		}
		
		
		
	}

}
