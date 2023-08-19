package programsProblem.practice.linkedList;

public class MyLinkedList {
	private int value;
	private MyLinkedList link;

	public MyLinkedList() {}	//default constructor
	
	public MyLinkedList(int value) {	//parameterise constructor
		this.setValue(value);
	}

	//Getter & Setter
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MyLinkedList getLink() {
		return link;
	}

	public void setLink(MyLinkedList link) {
		this.link = link;
	}
}
