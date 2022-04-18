import java.util.Arrays;

public class ArrayFrontBackCappedList<T> implements FrontBackCappedListInterface<T> 
{
	private T[] list;
	private int numberOfElements;
	protected final int capacity;

	public ArrayFrontBackCappedList(int capacity) 
	{
		if (capacity >=0)
		{
			list = (T[]) new Object[capacity]; //instantiate an array of Objects and then cast to T[]
			this.capacity = capacity;
			numberOfElements = 0;
		}
		else
			throw new NegativeArraySizeException("Capacity cannot be negative.");

	}
	
	public boolean addFront(T newEntry) 
	{

		if (!isFull())//there's at least one open space
		{
			makeRoomAtFront();
			list[0] = newEntry;
			numberOfElements++;
			return true;
		}		
		else
			return false; //if full or capacity is zero(would still be full)
	}
	
	public boolean addBack(T newEntry)
	{
		if (!isFull() && isEmpty()) //has space and numberOfElements = 0
		{
			list[0] = newEntry;
			numberOfElements++;
			return true;
		}
		else if (!isFull() && !isEmpty()) //has space and numberOfElements > 0
		{
			list[numberOfElements] = newEntry;
			numberOfElements++;
			return true;
		}
		else
			return false;
	}
	
	public T removeFront()
	{
		T result = null; //result will not change if numberOfElements = 0;
		if (numberOfElements == 1)
			result = removeBack(); //return object that was removed.		
		else if (numberOfElements > 1)
		{
			result = list[0];
			fillGapAtFront();
			numberOfElements--;
		}
		
		return result;
	}
	public T removeBack()
	{
		T result = null; //result will not change if numberOfElements = 0;
		if (numberOfElements == 1)
		{
			result = list[0];
			numberOfElements--;
			list[0] = null;
		}
		else if (numberOfElements > 1)
		{
			result = list[numberOfElements-1];
			list[numberOfElements-1] = null;
			numberOfElements--;
		}
		return result; 
		
	}
	
	public void clear()
	{
		int sizeHolder = numberOfElements;
		for (int i=0; i<sizeHolder; i++)
		{
			list[i] = null;
			numberOfElements--;
			
		}
	}
	
	public T getEntry(int givenPosition)
	{
		if((0<= givenPosition) && (givenPosition-1 <=numberOfElements))
			return list[givenPosition];
		else
			return null;
	}
	
	@SuppressWarnings("unused")
	public int indexOf(T anEntry)
	{
		int index = -1;
		for(int i=0; i< numberOfElements; i++)
		{
			if (list[i].equals(anEntry))
				return i;							
		}
		return index;
	}
	
	@SuppressWarnings("unused")
	public int lastIndexOf(T anEntry)
	{
		int index = -1;
		for(int i=numberOfElements-1; 0<=i; i--)
		{
			if (list[i].equals(anEntry))
				return i;					
		}
		return index;		
	}
	
	public boolean contains(T anEntry)
	{
		boolean result = false;
		for(int i=0; i< numberOfElements; i++)
		{
			if (list[i].equals(anEntry))
				result = true;
		}
		return result;
	}
	
	public int size()
	{
		return numberOfElements;
	}
	
	public boolean isEmpty()
	{
		return numberOfElements == 0;
	}
	
	public boolean isFull()
	{
		return capacity == numberOfElements;
	}
	
	@Override
	public String toString()
	{
		return "size=" + numberOfElements + "; " + "capacity=" + capacity + ";\t" +
				(isEmpty()? "[]" : displayContents()); 	
//				(isEmpty()? "[]" : Arrays.toString(list)); 	
	}	

	private String displayContents()
	{
		String contents = "[";
		
		for (int i=0; i< numberOfElements-1;i++)
		{
			contents = contents + list[i] + ", ";
		}
		contents = contents + list[numberOfElements-1] +"]";
		return contents;
	}
	
	private void makeRoomAtFront()
	{
		for (int i=numberOfElements-1; 0 <= i; i--)
		{
			list[i+1] = list[i];
		}
	}
	
	private void fillGapAtFront()
	{
		for (int i=0; i<numberOfElements-1;i++)
		{
			list[i] = list[i+1];
		}
	}
	
}//end of class
