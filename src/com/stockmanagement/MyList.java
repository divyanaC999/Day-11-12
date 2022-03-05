package com.stockmanagement;

public class MyList<T> {
	MyNode<T> head;
	MyNode<T> current;
	int position;

	public MyList() {
		head = null;
		current = null;
		position = -1;
	}

	public void add(T data) {
		MyNode<T> node = new MyNode<T>(data);
		if (head == null) {
			head = node;
			current = head;
		} else {
			current.next = node;
			current = current.next;
		}
		position++;
	}

	public void remove(T data) {
		MyNode<T> tempCurrent = head;
		MyNode<T> tempPrev = null;
		while (!tempCurrent.data.equals(data)) {
			tempPrev = tempCurrent;
			tempCurrent = tempCurrent.next;
		}
		if (tempCurrent == head) {
			head = head.next;
		} else {
			tempPrev.next = tempCurrent.next;
		}
		if (tempCurrent == current) {
			current = tempPrev;
		}
		position--;
	}

	public boolean search(T data) {
		return index(data) == -1 ? false : true;
	}

	public boolean isEmpty() {
		return position == -1 ? true : false;
	}

	public int size() {
		return position + 1;
	}

	public void append(T data) {
		add(data);
	}

	public int index(T data) {
		if (position == -1) {
			return -1;
		}
		MyNode<T> tempCurrent = head;
		int tempPosition = 0;

		while (!tempCurrent.data.equals(data)) {
			if (tempCurrent == current) {
				return -1;
			}
			tempCurrent = tempCurrent.next;
			tempPosition++;
		}
		return tempPosition;
	}

	public void insert(int pos, T data) {

		if ((pos == position + 1) || (position == -1)) {
			add(data);
		} else if (pos == 0) {
			MyNode<T> tempNode = head;
			head = new MyNode<T>(data);
			head.next = tempNode;
		} else {
			MyNode<T> tempCurrent = head;
			MyNode<T> tempPrev = null;
			int tempPosition = 0;
			while (tempPosition <= pos + 1) {
				tempPrev = tempCurrent;
				tempCurrent = tempCurrent.next;
				tempPosition++;
			}
			MyNode<T> newNode = new MyNode<T>(data);
			newNode.next = tempCurrent;
			tempPrev.next = newNode;
		}
		position++;
	}

	public T pop(int location) {
		MyNode<T> tempCurrent = head;
		MyNode<T> tempPrev = null;
		int tempPosition = 0;
		position--;
		while (tempPosition != location) {
			tempPrev = tempCurrent;
			tempCurrent = tempCurrent.next;
			tempPosition++;
		}
		if (tempCurrent == head) {
			head = head.next;
			return tempCurrent.data;
		} else if (tempCurrent == current) {
			current = tempPrev;
			tempPrev.next = tempCurrent.next;
			return tempCurrent.data;
		} else {
			tempPrev.next = tempCurrent.next;
			return tempCurrent.data;
		}
	}

	public T pop() {
		return pop(position);
	}

	public void list() {
		MyNode<T> tempCurrent = head;
		while (tempCurrent != null) {
			System.out.println(tempCurrent.data);
			tempCurrent = tempCurrent.next;
		}
	}
}

class MyNode<T> {
	T data;
	MyNode<T> next;

	MyNode(T data) {
		this.data = data;
		next = null;
	}
}
