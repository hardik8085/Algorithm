package algoCode.BinarySearch;

import java.util.HashMap;
import java.util.Scanner;

import com.sun.xml.internal.ws.encoding.RootOnlyCodec;

public class BinarySearchTree {
	static HashMap<Integer, BinaryObject> hashMapObject;
	static BinaryObject binaryObject;
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
				binaryObject = new BinaryObject(-1, -1, -1, -1, -1, 0);
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
		BinaryObject tempObject = hashMapObject.get(parent);
		if (number < parent) {
			if (tempObject.getLeft() == -1) {
				tempObject.setLeft(number);
				binaryObject = new BinaryObject(parent, -1, -1, -1, -1, 0);
				hashMapObject.put(number, binaryObject);

			} else {
				int leftNumber = tempObject.getLeft();
				setDataToBinaryTree(number, leftNumber);
			}
		}

		else {
			if (tempObject.getRight() == -1) {
				tempObject.setRight(number);
				binaryObject = new BinaryObject(parent, -1, -1, -1, -1, 0);
				hashMapObject.put(number, binaryObject);

			} else {
				int rightNumber = tempObject.getRight();
				setDataToBinaryTree(number, rightNumber);
			}
		}
	}

	public static void setHeightAtAllLevel(int number) {
		BinaryObject parent = hashMapObject.get(number);
		if (parent.getParent() != -1) {
			setHeight(parent.getParent());
		}
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

	// set height after right round process

	public static void setHeightAfterRightRound(int number) {
		BinaryObject root = hashMapObject.get(number);
		int leftHeight = root.getLeftHeight();
		BinaryObject rightObject = null;
		BinaryObject rightLeftObject = null;
		BinaryObject rightRightObject = null;
		int rightLeftHeight = -1;
		int rightRightHeight = -1;

		System.out.println("inside set height after right round");
		if ((hashMapObject.get(number)).getRight() != -1) {
			rightObject = hashMapObject.get((hashMapObject.get(number)).getRight());

		}
		if ((hashMapObject.get((hashMapObject.get(number)).getRight())).getLeft() != -1) {
			rightLeftObject = hashMapObject.get((hashMapObject.get((hashMapObject.get(number)).getRight())).getLeft());
			rightLeftHeight = rightLeftObject.getHeight();

		}

		if ((hashMapObject.get((hashMapObject.get(number)).getRight())).getRight() != -1) {
			rightRightObject = hashMapObject
					.get((hashMapObject.get((hashMapObject.get(number)).getRight())).getRight());
			rightRightHeight = rightRightObject.getHeight();

		}

		rightObject.setLeftHeight(rightLeftHeight);
		rightObject.setRightHeight(rightRightHeight);
		if (rightLeftHeight > rightRightHeight) {
			rightObject.setHeight(rightLeftHeight + 1);
			System.out.println(rightLeftHeight + 1);
		} else {
			rightObject.setHeight(rightRightHeight + 1);
		}

		if (leftHeight > rightObject.getHeight()) {
			root.setHeight(leftHeight + 1);
		} else {
			root.setHeight(rightObject.getHeight() + 1);
		}

		root.setRightHeight(rightObject.getHeight());

		setHeightAtAllLevel(number);
	}

	// set height after left round process

	public static void setHeightAfterLeftRounnd(int number) {

		BinaryObject root = null;
		BinaryObject leftRightChild = null;
		BinaryObject leftLeftChild = null;
		BinaryObject rightChild = null;
		BinaryObject rootParent = null;
		BinaryObject leftChild = null;
		int rootHeight = -1;
		int leftRightHeight = -1;
		int leftLeftHeight = -1;
		int rightHeight = -1;

		root = hashMapObject.get(number);

		if (hashMapObject.get(number).getLeft() != -1) {
			leftChild = hashMapObject.get((hashMapObject.get(number)).getLeft());
		}

		if (hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight() != -1) {
			leftRightChild = hashMapObject
					.get(hashMapObject.get(hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight()));

		}
		if (hashMapObject.get(hashMapObject.get(number).getLeft()).getLeft() != -1) {
			leftLeftChild = hashMapObject
					.get(hashMapObject.get(hashMapObject.get(hashMapObject.get(number).getRight()).getLeft()));

		}

		if (hashMapObject.get(number).getRight() != -1) {
			rightChild = hashMapObject.get(hashMapObject.get(number).getRight());
		}
		if (hashMapObject.get(number).getParent() != -1) {
			rootParent = hashMapObject.get(hashMapObject.get(number).getParent());
		}
 
		rootHeight = hashMapObject.get(number).getHeight();
		if (leftLeftChild != null) {
			leftLeftHeight = leftLeftChild.getHeight();
			 

		}

		if (leftRightChild != null) {
			leftRightHeight = leftRightChild.getHeight();
		}

		if (leftLeftHeight > leftRightHeight) {
			leftChild.setHeight(leftLeftHeight + 1);
			root.setLeftHeight(leftLeftHeight + 1);
		} else {
			leftChild.setHeight(leftRightHeight + 1);
			root.setRightHeight(leftRightHeight + 1);
		}

		if (leftChild.getHeight() > rightChild.getHeight()) {
			root.setHeight(leftChild.getHeight() + 1);
			if (rootParent != null) {
				rootParent.setLeftHeight(root.getLeftHeight() + 1);
			}
		} else {
			root.setHeight(rightChild.getHeight() + 1);
			if (rootParent != null) {
				rootParent.setRightHeight(root.getRightHeight() + 1);
			}
		}

//		if (rootParent.getLeftHeight() > rootParent.getRightHeight()) {
//			rootParent.setHeight(rootParent.getLeftHeight() + 1);
//		} else {
//			rootParent.setHeight(rootParent.getRightHeight() + 1);
//		}

	}

	// By using recurrence set the height of the number

	public static void setHeight(int number) {

		BinaryObject parent = hashMapObject.get(number);
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

	// check difference of the height of the child nodes of binary tree

	public static void heightChecker(int number) {

		BinaryObject parent = hashMapObject.get(number);

		if (Math.abs(parent.getLeftHeight() - parent.getRightHeight()) >= 2) {
			roundingProcess(number);
		}
	}

	// Manage all the rounding process by calling right and left round and set
	// new height accordingly

	public static void roundingProcess(int number) {
		if (hashMapObject.get(number).getRightHeight() > hashMapObject.get(number).getLeftHeight()) {
			BinaryObject rightSide = hashMapObject.get(hashMapObject.get(number).getRight());
			if (rightSide.getRightHeight() > rightSide.getLeftHeight()) {
				System.out.println("round on left" + number);
				leftRound(number);
			} else {
				rightRound(hashMapObject.get(number).getRight());
				System.out.println("round on right" + hashMapObject.get(number).getRight());
				leftRound(number);
				System.out.println("round left on " + number);
			}
		} else {

			BinaryObject leftSide = hashMapObject.get((hashMapObject.get(number)).getLeft());
			if (leftSide.getLeftHeight() >= leftSide.getRightHeight()) {
				System.out.println("right roung on " + number);
				rightRound(number);
			} else {
				leftRound(hashMapObject.get(number).getLeft());
				rightRound(number);
				System.out.println("round on left" + hashMapObject.get(number).getLeft());
				System.out.println("round right on " + number);
			}

		}

	}

	// Left round of the number
	public static void leftRound(int number) {
		BinaryObject rootObject = hashMapObject.get(number);
		int rightLeftNumber = -1;
		int rightRightNumber = -1;
		BinaryObject leftChildObject, rightLeftChildObject, rightRightChildObject, rightChildObject = null;
		BinaryObject rootParent = null;
		int rightChildNumber = -1;
		int rootParentNumber = -1;

		if (hashMapObject.get(number).getParent() != -1) {
			rootParent = hashMapObject.get(hashMapObject.get(number).getParent());
			rootParentNumber = hashMapObject.get(number).getParent();
		}
		if (hashMapObject.get(number).getLeft() != -1) {
			leftChildObject = hashMapObject.get((hashMapObject.get(number)).getLeft());

		}
		rightChildObject = hashMapObject.get(hashMapObject.get(number).getRight());
		rightChildNumber = (hashMapObject.get(number)).getRight();
		if (hashMapObject.get(number).getRight() != -1) {
			if ((hashMapObject.get(hashMapObject.get(number).getRight()).getLeft()) != -1) {
				rightLeftChildObject = hashMapObject
						.get(hashMapObject.get((hashMapObject.get(number)).getRight()).getLeft());
				rightLeftNumber = hashMapObject.get(hashMapObject.get(number).getRight()).getLeft();

			}
			if (rightChildObject.getRight() != -1) {
				rightRightChildObject = hashMapObject.get(rightChildObject.getRight());
				rightRightNumber = rightChildObject.getRight();
			}
			int right = hashMapObject.get(number).getRight();

			if (rootParent != null) {
				rootParent.setRight(right);
			}

		}
		int left = hashMapObject.get(number).getLeft();
		rootObject.setRight(rightLeftNumber);

		rightChildObject.setParent(rootParentNumber);
		rightChildObject.setLeft(number);

		rootObject.setParent(rightChildNumber);
		if (rootParentNumber == -1) {
			root = rightChildNumber;
		}
		System.out.println(hashMapObject.toString());

		setHeightAfterLeftRounnd(rightChildNumber);

	}

	// Right round of the number
	public static void rightRound(int number) {
		BinaryObject leftChildObject = null;
		BinaryObject rightChildObject = null;
		BinaryObject leftRightChildObject = null;
		BinaryObject rootParent = null;
		rootParent = null;
		leftRightChildObject = null;
		int rootParentNumber = -1;
		int leftChildNumber = -1;
		int rightChildNumber = -1;
		int leftRightChildNumber = -1;
		BinaryObject rootObject = hashMapObject.get(number);
		leftChildObject = hashMapObject.get((hashMapObject.get(number)).getLeft());

		leftChildNumber = (hashMapObject.get(number)).getLeft();
		if (hashMapObject.get(number).getRight() != -1) {
			rightChildObject = hashMapObject.get((hashMapObject.get(number)).getRight());
			rightChildNumber = (hashMapObject.get(number)).getRight();
		}
		if ((hashMapObject.get(hashMapObject.get(number).getLeft()).getRight()) != -1) {
			leftRightChildObject = hashMapObject
					.get(hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight());
			leftRightChildNumber = hashMapObject.get(hashMapObject.get(number).getLeft()).getRight();

		}
		if (hashMapObject.get(number).getParent() != -1) {
			rootParent = hashMapObject.get(hashMapObject.get(hashMapObject.get(number).getParent()));
			rootParentNumber = (hashMapObject.get(number)).getParent();
		}

		leftChildObject.setParent(rootParentNumber);
		int left = hashMapObject.get(number).getLeft();
		int right = hashMapObject.get(number).getRight();
		rootObject.setLeft(leftRightChildNumber);
		rootObject.setParent(leftChildNumber);
		leftChildObject.setParent(rootParentNumber);
		if (rootParentNumber == -1) {
			root = leftChildNumber;
		}
		leftChildObject.setRight(number);
		System.out.println(hashMapObject.toString());

		setHeightAfterRightRound(leftChildNumber);

	}
}
package algoCode.BinarySearch;

import java.util.HashMap;
import java.util.Scanner;

import com.sun.xml.internal.ws.encoding.RootOnlyCodec;

public class BinarySearchTree {
	static HashMap<Integer, BinaryObject> hashMapObject;
	static BinaryObject binaryObject;
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
				binaryObject = new BinaryObject(-1, -1, -1, -1, -1, 0);
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
		BinaryObject tempObject = hashMapObject.get(parent);
		if (number < parent) {
			if (tempObject.getLeft() == -1) {
				tempObject.setLeft(number);
				binaryObject = new BinaryObject(parent, -1, -1, -1, -1, 0);
				hashMapObject.put(number, binaryObject);

			} else {
				int leftNumber = tempObject.getLeft();
				setDataToBinaryTree(number, leftNumber);
			}
		}

		else {
			if (tempObject.getRight() == -1) {
				tempObject.setRight(number);
				binaryObject = new BinaryObject(parent, -1, -1, -1, -1, 0);
				hashMapObject.put(number, binaryObject);

			} else {
				int rightNumber = tempObject.getRight();
				setDataToBinaryTree(number, rightNumber);
			}
		}
	}

	public static void setHeightAtAllLevel(int number) {
		BinaryObject parent = hashMapObject.get(number);
		if (parent.getParent() != -1) {
			setHeight(parent.getParent());
		}
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

	// set height after right round process

	public static void setHeightAfterRightRound(int number) {
		BinaryObject root = hashMapObject.get(number);
		int leftHeight = root.getLeftHeight();
		BinaryObject rightObject = null;
		BinaryObject rightLeftObject = null;
		BinaryObject rightRightObject = null;
		int rightLeftHeight = -1;
		int rightRightHeight = -1;

		System.out.println("inside set height after right round");
		if ((hashMapObject.get(number)).getRight() != -1) {
			rightObject = hashMapObject.get((hashMapObject.get(number)).getRight());

		}
		if ((hashMapObject.get((hashMapObject.get(number)).getRight())).getLeft() != -1) {
			rightLeftObject = hashMapObject.get((hashMapObject.get((hashMapObject.get(number)).getRight())).getLeft());
			rightLeftHeight = rightLeftObject.getHeight();

		}

		if ((hashMapObject.get((hashMapObject.get(number)).getRight())).getRight() != -1) {
			rightRightObject = hashMapObject
					.get((hashMapObject.get((hashMapObject.get(number)).getRight())).getRight());
			rightRightHeight = rightRightObject.getHeight();

		}

		rightObject.setLeftHeight(rightLeftHeight);
		rightObject.setRightHeight(rightRightHeight);
		if (rightLeftHeight > rightRightHeight) {
			rightObject.setHeight(rightLeftHeight + 1);
			System.out.println(rightLeftHeight + 1);
		} else {
			rightObject.setHeight(rightRightHeight + 1);
		}

		if (leftHeight > rightObject.getHeight()) {
			root.setHeight(leftHeight + 1);
		} else {
			root.setHeight(rightObject.getHeight() + 1);
		}

		root.setRightHeight(rightObject.getHeight());

		setHeightAtAllLevel(number);
	}

	// set height after left round process

	public static void setHeightAfterLeftRounnd(int number) {

		BinaryObject root = null;
		BinaryObject leftRightChild = null;
		BinaryObject leftLeftChild = null;
		BinaryObject rightChild = null;
		BinaryObject rootParent = null;
		BinaryObject leftChild = null;
		int rootHeight = -1;
		int leftRightHeight = -1;
		int leftLeftHeight = -1;
		int rightHeight = -1;

		root = hashMapObject.get(number);

		if (hashMapObject.get(number).getLeft() != -1) {
			leftChild = hashMapObject.get((hashMapObject.get(number)).getLeft());
		}

		if (hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight() != -1) {
			leftRightChild = hashMapObject
					.get(hashMapObject.get(hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight()));

		}
		if (hashMapObject.get(hashMapObject.get(number).getLeft()).getLeft() != -1) {
			leftLeftChild = hashMapObject
					.get(hashMapObject.get(hashMapObject.get(hashMapObject.get(number).getRight()).getLeft()));

		}

		if (hashMapObject.get(number).getRight() != -1) {
			rightChild = hashMapObject.get(hashMapObject.get(number).getRight());
		}
		if (hashMapObject.get(number).getParent() != -1) {
			rootParent = hashMapObject.get(hashMapObject.get(number).getParent());
		}
 
		rootHeight = hashMapObject.get(number).getHeight();
		if (leftLeftChild != null) {
			leftLeftHeight = leftLeftChild.getHeight();
			 

		}

		if (leftRightChild != null) {
			leftRightHeight = leftRightChild.getHeight();
		}

		if (leftLeftHeight > leftRightHeight) {
			leftChild.setHeight(leftLeftHeight + 1);
			root.setLeftHeight(leftLeftHeight + 1);
		} else {
			leftChild.setHeight(leftRightHeight + 1);
			root.setRightHeight(leftRightHeight + 1);
		}

		if (leftChild.getHeight() > rightChild.getHeight()) {
			root.setHeight(leftChild.getHeight() + 1);
			if (rootParent != null) {
				rootParent.setLeftHeight(root.getLeftHeight() + 1);
			}
		} else {
			root.setHeight(rightChild.getHeight() + 1);
			if (rootParent != null) {
				rootParent.setRightHeight(root.getRightHeight() + 1);
			}
		}

//		if (rootParent.getLeftHeight() > rootParent.getRightHeight()) {
//			rootParent.setHeight(rootParent.getLeftHeight() + 1);
//		} else {
//			rootParent.setHeight(rootParent.getRightHeight() + 1);
//		}

	}

	// By using recurrence set the height of the number

	public static void setHeight(int number) {

		BinaryObject parent = hashMapObject.get(number);
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

	// check difference of the height of the child nodes of binary tree

	public static void heightChecker(int number) {

		BinaryObject parent = hashMapObject.get(number);

		if (Math.abs(parent.getLeftHeight() - parent.getRightHeight()) >= 2) {
			roundingProcess(number);
		}
	}

	// Manage all the rounding process by calling right and left round and set
	// new height accordingly

	public static void roundingProcess(int number) {
		if (hashMapObject.get(number).getRightHeight() > hashMapObject.get(number).getLeftHeight()) {
			BinaryObject rightSide = hashMapObject.get(hashMapObject.get(number).getRight());
			if (rightSide.getRightHeight() > rightSide.getLeftHeight()) {
				System.out.println("round on left" + number);
				leftRound(number);
			} else {
				rightRound(hashMapObject.get(number).getRight());
				System.out.println("round on right" + hashMapObject.get(number).getRight());
				leftRound(number);
				System.out.println("round left on " + number);
			}
		} else {

			BinaryObject leftSide = hashMapObject.get((hashMapObject.get(number)).getLeft());
			if (leftSide.getLeftHeight() >= leftSide.getRightHeight()) {
				System.out.println("right roung on " + number);
				rightRound(number);
			} else {
				leftRound(hashMapObject.get(number).getLeft());
				rightRound(number);
				System.out.println("round on left" + hashMapObject.get(number).getLeft());
				System.out.println("round right on " + number);
			}

		}

	}

	// Left round of the number
	public static void leftRound(int number) {
		BinaryObject rootObject = hashMapObject.get(number);
		int rightLeftNumber = -1;
		int rightRightNumber = -1;
		BinaryObject leftChildObject, rightLeftChildObject, rightRightChildObject, rightChildObject = null;
		BinaryObject rootParent = null;
		int rightChildNumber = -1;
		int rootParentNumber = -1;

		if (hashMapObject.get(number).getParent() != -1) {
			rootParent = hashMapObject.get(hashMapObject.get(number).getParent());
			rootParentNumber = hashMapObject.get(number).getParent();
		}
		if (hashMapObject.get(number).getLeft() != -1) {
			leftChildObject = hashMapObject.get((hashMapObject.get(number)).getLeft());

		}
		rightChildObject = hashMapObject.get(hashMapObject.get(number).getRight());
		rightChildNumber = (hashMapObject.get(number)).getRight();
		if (hashMapObject.get(number).getRight() != -1) {
			if ((hashMapObject.get(hashMapObject.get(number).getRight()).getLeft()) != -1) {
				rightLeftChildObject = hashMapObject
						.get(hashMapObject.get((hashMapObject.get(number)).getRight()).getLeft());
				rightLeftNumber = hashMapObject.get(hashMapObject.get(number).getRight()).getLeft();

			}
			if (rightChildObject.getRight() != -1) {
				rightRightChildObject = hashMapObject.get(rightChildObject.getRight());
				rightRightNumber = rightChildObject.getRight();
			}
			int right = hashMapObject.get(number).getRight();

			if (rootParent != null) {
				rootParent.setRight(right);
			}

		}
		int left = hashMapObject.get(number).getLeft();
		rootObject.setRight(rightLeftNumber);

		rightChildObject.setParent(rootParentNumber);
		rightChildObject.setLeft(number);

		rootObject.setParent(rightChildNumber);
		if (rootParentNumber == -1) {
			root = rightChildNumber;
		}
		System.out.println(hashMapObject.toString());

		setHeightAfterLeftRounnd(rightChildNumber);

	}

	// Right round of the number
	public static void rightRound(int number) {
		BinaryObject leftChildObject = null;
		BinaryObject rightChildObject = null;
		BinaryObject leftRightChildObject = null;
		BinaryObject rootParent = null;
		rootParent = null;
		leftRightChildObject = null;
		int rootParentNumber = -1;
		int leftChildNumber = -1;
		int rightChildNumber = -1;
		int leftRightChildNumber = -1;
		BinaryObject rootObject = hashMapObject.get(number);
		leftChildObject = hashMapObject.get((hashMapObject.get(number)).getLeft());

		leftChildNumber = (hashMapObject.get(number)).getLeft();
		if (hashMapObject.get(number).getRight() != -1) {
			rightChildObject = hashMapObject.get((hashMapObject.get(number)).getRight());
			rightChildNumber = (hashMapObject.get(number)).getRight();
		}
		if ((hashMapObject.get(hashMapObject.get(number).getLeft()).getRight()) != -1) {
			leftRightChildObject = hashMapObject
					.get(hashMapObject.get((hashMapObject.get(number)).getLeft()).getRight());
			leftRightChildNumber = hashMapObject.get(hashMapObject.get(number).getLeft()).getRight();

		}
		if (hashMapObject.get(number).getParent() != -1) {
			rootParent = hashMapObject.get(hashMapObject.get(hashMapObject.get(number).getParent()));
			rootParentNumber = (hashMapObject.get(number)).getParent();
		}

		leftChildObject.setParent(rootParentNumber);
		int left = hashMapObject.get(number).getLeft();
		int right = hashMapObject.get(number).getRight();
		rootObject.setLeft(leftRightChildNumber);
		rootObject.setParent(leftChildNumber);
		leftChildObject.setParent(rootParentNumber);
		if (rootParentNumber == -1) {
			root = leftChildNumber;
		}
		leftChildObject.setRight(number);
		System.out.println(hashMapObject.toString());

		setHeightAfterRightRound(leftChildNumber);

	}
}
