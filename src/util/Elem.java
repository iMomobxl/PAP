package util;

import java.util.Objects;

public class Elem<T> {

	private T info;
	private Elem<T> suiv;
	
	// "source/generate constructeur using fields"
	//
	// constructeur, avec un Elem suivant
	//
	public Elem(T info, Elem<T> suiv) {
		this.info = info;
		this.suiv = suiv;
	}
	
	// constructeur, sans un Elem suivant cad le 1er
	public Elem(T info) {
		this.info = info;
		this.suiv = null;
	}
	
	// "source/generate seter and getter"
	//
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public Elem<T> getSuiv() {
		return suiv;
	}

	public void setSuiv(Elem<T> suiv) {
		this.suiv = suiv;
	}

	// "source/generate toString()"
	//
	public String toString() {
		return "Elem [info=" + info + ", suiv=" + suiv + "]";
	}


	// "source/generate hashCode() ..."
	//
	
	
	@Override
	public int hashCode() {
		return Objects.hash(info, suiv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elem other = (Elem) obj;
		return Objects.equals(info, other.info) && Objects.equals(suiv, other.suiv);
	}
	
	
	
	
	
	
}
