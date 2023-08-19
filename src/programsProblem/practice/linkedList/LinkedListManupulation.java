package programsProblem.practice.linkedList;

public class LinkedListManupulation {
	
	public MyLinkedList getDuplicate(MyLinkedList linkedList) {
		MyLinkedList tempList = new MyLinkedList();
		
		tempList.setValue(linkedList.getValue());
		tempList.setLink(linkedList.getLink());
		
		return tempList;
	}
	
	public int getLength(MyLinkedList list) {
		int count = 0;
		MyLinkedList duplicate = getDuplicate(list);
		while(duplicate.getLink() != null) {
			count++;
			duplicate = duplicate.getLink();
			
			if(duplicate.getLink() == null)
				count++;
		}
		return count;
	}
	
	public void getAll(MyLinkedList list) {
		MyLinkedList duplicate = getDuplicate(list);
		
		while(duplicate.getLink() != null) {
			System.out.println(duplicate.getValue());
			
			duplicate = duplicate.getLink();
			
			if(duplicate.getLink() == null)
				System.out.println(duplicate.getValue());
		}
	}
	
	public void getFirst(MyLinkedList list) {
		System.out.println(list.getValue());
	}
	
	public void getLast(MyLinkedList list) {
		MyLinkedList duplicate = getDuplicate(list);
		
		while(duplicate.getLink() !=  null) {
			if(duplicate.getLink().getLink() ==  null) {
				System.out.println(duplicate.getLink().getValue());
			}
			duplicate = duplicate.getLink();
		}
	}
	
	public void getAtIndex(MyLinkedList list, int index) {
		if(index > getLength(list))
			System.out.println("Length should be less than List size.");
		
		MyLinkedList duplicate = getDuplicate(list);
		
		for(int i = 0; i <= index; i++) {
			if(index == 0) {
				System.out.println(duplicate.getValue());
			}
			
			duplicate = duplicate.getLink();
			
			if(i == index - 1) {
				System.out.println(duplicate.getValue());
				break;
			}
		}
	}
	
	public void putLast(MyLinkedList original, MyLinkedList newLink) {
		if(original == null) {
			original.setValue(newLink.getValue());
			original.setLink(newLink.getLink());
		}
		else {
			MyLinkedList last = original;
			while(last.getLink() != null) {
				last = last.getLink();
			}
			last = newLink;
		}
	}
}
