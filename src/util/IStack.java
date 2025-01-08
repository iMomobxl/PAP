package util;

public interface IStack<T> {

	void push(T elem);

	T pop();

	boolean empty();

	T top();

}