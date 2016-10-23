package algoCode.AVLTree.copy;

import java.util.HashMap;
import java.util.Scanner;

import com.sun.xml.internal.ws.encoding.RootOnlyCodec;

public class AVLTree {
	static HashMap<Integer, AVLObject> hashMapObject;
	static AVLObject binaryObject;
	static int root = -1;
	static int input;

	public static void main(String[] args) {
		System.out.println("Enter the number ");
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextInt();
		hashMapObject = new HashMap<>();

		while (input != -1) {
			if (hashMapObject.isEmpty()) {
				root = input;
				binaryObject = new AVLObject(-1, -1, -1, -1, -1, 0);
				hashMapObject.put(input, binaryObject);
				input = scanner.nextInt();

			} else {

				setDataToBinaryTree(input, root);
				setHeightAtAllLevel(input);
				input = scanner.nextInt();
			}

		}

		System.out.println(hashMapObject.toString());
	}

	public static void setDataToBinaryTree(int number, int parent) {
		AVLObject tempObject = hashMapObject.get(parent);
		if (number < parent) {
			if (tempObject.getLeft() == -1) {
				tempObject.setLeft(number);
				binaryObject = new AVLObject(parent, -1, -1, -1, -1, 0);
				hashMapObject.put(number, binaryObject);

			} else {
				int leftNumber = tempObject.getLeft();
				setDataToBinaryTree(number, leftNumber);
			}
		}

		else {
			if (tempObject.getRight() == -1) {
				tempObject.setRight(number);
				binaryObject = new AVLObject(parent, -1, -1, -1, -1, 0);
				hashMapObject.put(number, binaryObject);

			} else {
				int rightNumber = tempObject.getRight();
				setDataToBinaryTree(number, rightNumber);
			}
		}
	}

	public static void setHeightAtAllLevel(int number) {
		AVLObject parent = hashMapObject.get(number);
		setHeight(parent.getParent());
		// if(hashMapObject.get(parent.getParent()).getParent() == -1){
		// System.out.println("inside the if statement");
		// if(hashMapObject.get(parent.getParent()).getLeftHeight() >
		// hashMapObject.get(parent.getParent()).getRightHeight()){
		// hashMapObject.get(parent.getParent()).setHeight(hashMapObject.get(parent.getParent()).getLeftHeight()+1);
		// }else{
		// hashMapObject.get(parent.getParent()).setHeight(hashMapObject.get(parent.getParent()).getRightHeight()+1);
		// }
		// }

	}

	public static void setHeight(int number) {

		AVLObject parent = hashMapObject.get(number);
		if (parent.getLeft() == -1 && parent.getRight() == -1) {
			parent.setHeight(0);
			parent.setLeftHeight(-1);
			parent.setRightHeight(-1);
			heightChecker(number);

			if (!(parent.getParent() == -1)) {
				setHeight(parent.getParent());

			}

		} else if (parent.getLeft() != -1 && parent.getRight() == -1) {
			parent.setHeight(hashMapObject.get(parent.getLeft()).getHeight() + 1);
			parent.setLeftHeight(hashMapObject.get(parent.getLeft()).getHeight());
			parent.setRightHeight(-1);
			heightChecker(number);

			 
			if (!(parent.getParent() == -1)) {
				setHeight(parent.getParent());
			}
 
		} else if (parent.getRight() != -1 && parent.getLeft() == -1) {
			parent.setHeight(hashMapObject.get(parent.getRight()).getHeight() + 1);
			parent.setRightHeight(hashMapObject.get(parent.getRight()).getHeight());
			parent.setLeftHeight(-1);
			heightChecker(number);

			if (!(parent.getParent() == -1)) {
				setHeight(parent.getParent());
			}

 
		} else {
			parent.setRightHeight(hashMapObject.get(parent.getRight()).getHeight());
			parent.setLeftHeight(hashMapObject.get(parent.getLeft()).getHeight());
			 
			if (hashMapObject.get(parent.getLeft()).getHeight() > hashMapObject.get(parent.getRight()).getHeight()) {
				parent.setHeight(hashMapObject.get(parent.getLeft()).getHeight() + 1);
				heightChecker(number);

				if (!(parent.getParent() == -1)) {
					setHeight(parent.getParent());
				}
 
			} else {
				parent.setHeight(hashMapObject.get(parent.getRight()).getHeight() + 1);
				heightChecker(number);

				if (!(parent.getParent() == -1)) {
					setHeight(parent.getParent());
				}
 
			}
		}

	}
	
	
	//check difference of the height of the child nodes of binary tree
	
	public static void heightChecker(int number){
 
		AVLObject parent = hashMapObject.get(number);
 		if (Math.abs(parent.getLeftHeight() - parent.getRightHeight()) >= 2) {
 			roundingProcess(number);
		}
	}

	public static void roundingProcess(int number){
		if(hashMapObject.get(number).getRightHeight()>hashMapObject.get(number).getLeftHeight()){
			AVLObject rightSide = hashMapObject.get(hashMapObject.get(number).getRight());
			if(rightSide.getRightHeight()>rightSide.getLeftHeight()){
				System.out.println("round on left"+ number);
				leftRound(number);
			}
			else{
				System.out.println("round on right"+ hashMapObject.get(number).getRight());
				System.out.println("round left on "+ number);
			}
		}
		else{
			
			AVLObject leftSide =hashMapObject.get((hashMapObject.get(number)).getLeft());
			if(leftSide.getLeftHeight()>leftSide.getRightHeight()){
				rightRound(number);
 			}
			else{
				System.out.println("round on left"+ hashMapObject.get(number).getLeft());
				System.out.println("round right on "+ number);
			}
			
		}
		
	}
	
	public static void leftRound(int number) {
		AVLObject rootObject = hashMapObject.get(number);
		int rightLeft = -1;
		AVLObject leftChildObject, rightLeftChildObject, rightChildObject;
		AVLObject rootParent = null;
		int rightChildNumber = -1;
		int rootParentNumber = -1;
		
		if(hashMapObject.get(number).getParent() != -1){
			 rootParent = hashMapObject.get(hashMapObject.get(number).getParent());
			 rootParentNumber = hashMapObject.get(number).getParent();
		}
 		if (hashMapObject.get(number).getLeft() != -1) {
			leftChildObject = hashMapObject.get((hashMapObject.get(number)).getLeft());
 
		}
		rightChildObject = hashMapObject.get((hashMapObject.get(number)).getRight());
		rightChildNumber = (hashMapObject.get(number)).getRight(); 
		if (hashMapObject.get(number).getRight() != -1) {
			if ((hashMapObject.get(hashMapObject.get(number).getRight()).getLeft()) != -1) {
				rightLeftChildObject = hashMapObject
						.get(hashMapObject.get((hashMapObject.get(number)).getRight()).getLeft());
				rightLeft = hashMapObject.get(hashMapObject.get(number).getRight()).getLeft();
 
			}
			int right = hashMapObject.get(number).getRight();

			if(rootParent != null){
				rootParent.setRight(right);
			}

		}
		int left = hashMapObject.get(number).getLeft();
		rootObject.setRight(rightLeft);
		rightChildObject.setLeft(number);
		rightChildObject.setParent(rootParentNumber);
		rootObject.setParent(rightChildNumber);
 		
		System.out.println(hashMapObject.toString());
	}

	public static void rightRound(int number) {
		int rightLeft = -1;
		AVLObject leftChildObject, rightChildObject, leftRightChildObject;
		AVLObject rootObject = hashMapObject.get(number);
		leftChildObject = hashMapObject.get((hashMapObject.get(number)).getLeft());

		System.out.println(leftChildObject.toString());
		if (hashMapObject.get(number).getRight() != -1) {
			rightChildObject = hashMapObject.get((hashMapObject.get(number)).getRight());
		}
		if ((hashMapObject.get(hashMapObject.get(number).getLeft()).getRight()) != -1) {
			leftRightChildObject = hashMapObject
					.get(hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight());
			rightLeft = hashMapObject.get(hashMapObject.get(number).getRight()).getLeft();

		}
		AVLObject rootParent = hashMapObject.get(hashMapObject.get(hashMapObject.get(number).getParent()));
		int left = hashMapObject.get(number).getLeft();
		int right = hashMapObject.get(number).getRight();
		rootParent.setLeft(left);
		rootObject.setLeft(rightLeft);
		leftChildObject.setRight(number);
	}
}
