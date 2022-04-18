import java.util.*;
//import java.util.ArrayList;



public class ListFrontBackCappedList<T> implements FrontBackCappedListInterface<T> 
{
	private List<T> list;
	private int numberOfElements;
	protected final int capacity;
	
	public ListFrontBackCappedList(int capacity) {
		list = new ArrayList<>(capacity);
		numberOfElements = 0;	
		this.capacity = capacity;
	}

	public boolean addFront(T newEntry) {
		if (!isFull()){
			list.add(0, newEntry);
			numberOfElements++;
			return true;
		}
		return false;
	}

	public boolean addBack(T newEntry) {
		if (!isFull()){
			list.add(newEntry);
			numberOfElements++;
			return true;
		}
		return false;
	}

	public T removeFront() {
		T result = null;
		if (!isEmpty()){
			result = list.remove(0);
			numberOfElements--;
		}
		return result;
	}

	public T removeBack() {
		T result = null;
		if (!isEmpty()){
			result = list.remove(numberOfElements-1);
			numberOfElements--;
		}
		return result;
	}

	public void clear() {
		list.clear();
		numberOfElements = 0;
	}

	public T getEntry(int givenPosition) {		
		if (numberOfElements > 0 &&  0 <=givenPosition && givenPosition <=numberOfElements-1)		
			return list.get(givenPosition);
		else
			return null;		
	}

	public int indexOf(T anEntry) {
		if (numberOfElements > 0)		
			return list.indexOf(anEntry);
		else if (numberOfElements == 0)
			return -1;
		else
			return -1;
	}

	public int lastIndexOf(T anEntry) {
		int index = -1;
		for(int i=numberOfElements-1; 0<=i; i--){
			if (list.get(i).equals(anEntry))
				return i;					
		}
		return index;	
	}

	public boolean contains(T anEntry) {		
		return list.contains(anEntry);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean isFull() {
		return list.size() == capacity;
	}
	
	@Override
	public String toString() {
//		T[] tempArray = (T[]) new Object[numberOfElements];
//		tempArray = list.toArray();
		
		return "size=" + numberOfElements + "; " + "capacity=" + capacity + ";\t" +	
				(isEmpty()? "[]" : displayContents()); 
		
//				(isEmpty()? "[]" : Arrays.toString(ArrayList.toArray())); 			
		
	}
	private String displayContents(){
		String contents = "[";
		
		for (int i=0; i< numberOfElements-1;i++){
			contents = contents + list.get(i) + ", ";
		}
		contents = contents + list.get(numberOfElements-1) +"]";
		return contents;
	}	

}
