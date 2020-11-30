package dataStructures;

public class StackImplementation {

	public static int top = -1;
	public static int STACK_LENGTH = 5;
	public static int[] stackArray = new int[STACK_LENGTH];

	private static void add(int i) {
		if (top == STACK_LENGTH) {
			System.out.println("Overflow condition");
		} else {
			top++;
			stackArray[top] = i;
		}

	}

	private static void viewStack() {
		for (int i = 0; i < stackArray.length; i++) {
			System.out.println(stackArray[i]);
		}
	}

	public static void main(String[] args) {
		add(5);
		add(6);
		add(7);
		add(8);
		add(9);
		viewStack();

	}

}
