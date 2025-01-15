package util;

public class TestStack {

	public static void main(String[] args) {
		StackInt s1 = new StackInt(3);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		
		System.out.println(s1.top());
		
		while (!s1.empty()) {
			System.out.println(s1.pop());
		}
		
		//s1.pop();
		
		IStack<Integer>s2 = new Stack<>(3);
		s2.push(10);
		s2.push(20);
		s2.push(30);
		s2.push(40);
		
		System.out.println(s2.top());
		
		while (!s2.empty()) {
			System.out.println(s2.pop());
		}
		
		//s1.pop();
		
		System.out.println("Stack:");

		IStack<String>s3 = new Stack<>(3);
		s3.push("10");
		s3.push("20");
		s3.push("30");
		s3.push("40");
		
		System.out.println(s3.top());
		
		while (!s3.empty()) {
			System.out.println(s3.pop());
		}
		
		//s1.pop();
		
		System.out.println("StackLinkedList:");
		IStack<String>s4 = new StackLinkedList<>();
		s4.push("10");
		s4.push("20");
		s4.push("30");
		s4.push("40");
		
		System.out.println(s4.top());
		
		while (!s4.empty()) {
			//System.out.println("pop() s4");
			System.out.println(s4.pop());
		}
		
		System.out.println("Elem:");		
		Elem<Integer> e1 = new Elem<Integer>(15);
		System.out.println(e1);
		Elem<Integer> e2 = new Elem<Integer>(15);
		System.out.println(e2);
		System.out.println("EGAL? " + e1.equals(e2));
		System.out.println("FIN");
	}
}
