package util;

public class StackLinkedList<T> implements IStack<T> {
	
	private Maillon<T> sommet = null;
	
	@Override
	public void push(T elem) {
		Maillon<T> p = new Maillon<T>(elem, sommet);
		sommet = p;
	}

	@Override
	public T pop() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		// V1:
		// Maillon<T> p = sommet;
		// sommet = sommet.suiv();
		// return p.info()
		
		// V2:
		// Maillon<T> p = sommet;
		// sommet = sommet.suiv();
		// T info = p.info();
		// p = null;
		// return info;
		
		// V3:
		T info = sommet.info();
		sommet = sommet.suiv();
		return info;
	}

	@Override
	public boolean empty() {
		return sommet == null;
	}

	@Override
	public T top() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return sommet.info();
	}

}

record Maillon<T>(T info, Maillon<T> suiv) {};
