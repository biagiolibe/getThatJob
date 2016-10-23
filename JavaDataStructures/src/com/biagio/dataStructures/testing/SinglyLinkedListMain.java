package com.biagio.dataStructures.testing;

import com.biagio.dataStructures.LinkedList.SinglyLinkedList;
import com.biagio.dataStructures.LinkedList.SinglyLinkedNode;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>();
		list.topBack();
		list.pushFront(3);
		list.pushBack(4);
		list.pushFront(2);
		list.pushFront(5);
		list.pushFront(6);
		System.out.println("size: "+list.getSize());
		System.out.println(list.toString());
		
		list.addBefore(7, list.getNode(2));
		list.addAfter(10, list.getNode(4));
		System.out.println(list.toString());
		
		list.erase(new SinglyLinkedNode<>(6));
		System.out.println(list.toString());
		
		System.out.println(list.topFront());
		System.out.println(list.topBack());
		
		list.popBack();
		System.out.println(list.toString());
		list.popFront();
		System.out.println(list.toString());
		System.out.println("size: "+list.getSize());
		System.out.println("Empty list? "+list.isEmpty());
		
		System.out.println("Element found? "+list.find(3));
	}

}
