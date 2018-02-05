public class Main {
	public static void main(String[] args) {
		//System.out.println("ArrayStack time!");
		ArrayStack<String> stack = new ArrayStack<String>();
		
		stack.push("3");
		String s = stack.toString();
		System.out.println(s);
		stack.push("4");
		s = stack.toString();
		System.out.println(s);
		s = stack.peek();
		System.out.println(s);
		s = stack.pop();
		System.out.println(s);
		s = stack.pop();
		System.out.println(s);
		s = stack.pop();
	}
}
