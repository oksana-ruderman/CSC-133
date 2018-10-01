package com.mycompany.a2;

import java.util.Vector;

public class GameObjectCollection implements ICollection{
	private Vector<GameObjects> theCollection;
	
	public GameObjectCollection() 
	{
		theCollection = new Vector<GameObjects> ( );
	}
	
	public void add(GameObjects newObject) 
	{
		theCollection.addElement(newObject);
	}
	
	public IIterator getIterator() 
	{
		return new GameObjectIterator( ) ;
	}

	private class GameObjectIterator implements IIterator {
		
		private int currElementIndex;
		
		public GameObjectIterator() {
			currElementIndex = -1;
		}
		public boolean hasNext() {
			if (theCollection.size ( ) <= 0) 
			{
				return false;
			}
			if (currElementIndex == theCollection.size() - 1 )
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		public GameObjects getNext( ) 
		{
			currElementIndex ++ ;
			return(theCollection.elementAt(currElementIndex));
		}
		
		public int size()
		{
			return theCollection.size();
		}
		
		public GameObjects get(int location){
			return theCollection.get(location);
		}
		//@Override
		public Object elementAt(int location) {
			return theCollection.elementAt(location);
		}
		public void removeElement(Object o) {
			theCollection.removeElement(o);
			currElementIndex--;
		}
	} 
}