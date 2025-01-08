package util;

import java.util.Arrays;

public class Stack<T> implements IStack<T> {
	
	private static final int inc = 20; // static = propriete de la classe, final = ne peut pas etre modifié
	private T[] v;
	private int sommet = 0; // = 0 pas obligatoire
	private int tmax;
	
	
	@SuppressWarnings("unchecked")
	public Stack(int tmax) {
		this.tmax = tmax;
		this.v = (T[]) new Object[tmax];
	}
	
	public Stack() {
		
	}
	
//	public void push(int elem) {
//		if (sommet == tmax) {
//			throw new ArrayIndexOutOfBoundsException();
//		}
//		v[sommet] = elem;
//		sommet++;		
//	}
	
	@Override
	public void push(T elem) {
		if (sommet == tmax) {
			augmenteTaille();
		}
		v[sommet] = elem;
		sommet++;		
	}

	/**
	 * 
	 */
	private void augmenteTaille() {
//	V1
//		tmax += stack.inc; // stack. pas obligatoire
//		v = Arrays.copyOf(v, tmax);
		
//  V2
//		int[] v2 = new int[tmax + inc];
//		for (int i = 0; i < tmax; i++) {
//			v2[i] = v[i]; 
//		}
//		tmax += stack.inc;
//		v = v2; // ATTENTION
		
//  V3
		int newTmax = tmax + inc;
		@SuppressWarnings("unchecked")
		T[] v3 = (T[]) new Object[tmax + inc];
		System.arraycopy(v, 0, v3, 0, tmax);
		tmax = newTmax;
		v = v3;
		
//		System.out.println("taille actuel: " + (tmax - inc) + " - taille stack +" + inc + " - total: " + tmax);
	}
	
	@Override
	public T pop() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		sommet--;
		return v[sommet];
	}
	
	@Override
	public boolean empty() {
		return sommet == 0;
	}
	
	@Override
	public T top() {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return v[sommet - 1];
	}
	
	
}
