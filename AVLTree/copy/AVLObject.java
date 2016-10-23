package algoCode.AVLTree.copy;

public class AVLObject {

	
	int parent;
	int left;
	int right;
	int rightHeight;
	int leftHeight;
	int height;
	public int getRightHeight() {
		return rightHeight;
	}
	public void setRightHeight(int rightHeight) {
		this.rightHeight = rightHeight;
	}
	public int getLeftHeight() {
		return leftHeight;
	}
	public void setLeftHeight(int leftHeight) {
		this.leftHeight = leftHeight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "BinaryObject [parent=" + parent + ", left=" + left + ", right=" + right + ", rightHeight=" + rightHeight
				+ ", leftHeight=" + leftHeight + ", height=" + height + "]";
	}
	 
	public AVLObject(int parent, int left, int right, int rightHeight, int leftHeight, int height) {
		super();
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.rightHeight = rightHeight;
		this.leftHeight = leftHeight;
		this.height = height;
	}
	public AVLObject() {
		super();
	}
	
	
	
}
