package com.mycompany.a2;

public interface IIterator {

	public boolean hasNext();

	public Object getNext();

	public Object get(int i);

	public int size();
	
	public Object elementAt(int i);
	
	public void removeElement(Object o);
	
	//public Object removeElementAt(int i);
}