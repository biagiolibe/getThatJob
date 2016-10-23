package com.biagio.dataStructures.LinkedList;

/**
 * A custom Singly Linked List implementation
 * @author biagio
 *
 * @param <T>
 */

public class SinglyLinkedList<T>{
	private SinglyLinkedNode<T> head;
	private SinglyLinkedNode<T> tail;
	private int size;
	
	public SinglyLinkedList(){
		head=new SinglyLinkedNode<T>();
		tail=new SinglyLinkedNode<T>();
		size=0;
	}
	/**
	 * return the size of the list
	 * @return the size of the list
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Insert a new node (with the specified key) in the front of the list
	 * @param key
	 */
	public void pushFront(T key){
		SinglyLinkedNode<T> newNode=new SinglyLinkedNode<T>(key);
		newNode.setNext(head.getNext());
		head.setNext(newNode);
		if(tail.getNext()==null){
			tail.setNext(newNode);
		}
		size++;
	}
	
	/**
	 * Return a copy of the node in front of the list (the first element)
	 * @return the first node of the list
	 */
	public SinglyLinkedNode<T> topFront(){
		if(head.getNext()==null){
			return null;
		}
		return new SinglyLinkedNode<T>(head.getNext());
	}
	
	/**
	 * Remove the first element in the list
	 * @return the removed element
	 */
	public SinglyLinkedNode<T> popFront(){
		if(head.getNext()==null){
			return null;
		}
		SinglyLinkedNode<T> removed=head.getNext();
		if(tail.getNext()==head.getNext()){
			tail.setNext(null);
		}
		head.setNext(head.getNext().getNext());
		size--;
		return removed;
	}
	
	/**
	 * Insert a new node (with the specified key) at the end of the list
	 * @param key
	 */
	public void pushBack(T key){
		SinglyLinkedNode<T> newNode=new SinglyLinkedNode<T>(key);
		if(tail.getNext()==null){//the list is empty
			head.setNext(newNode);
		}
		else{
			tail.getNext().setNext(newNode);
		}
		tail.setNext(newNode);
		size++;
	}
	
	/**
	 * Return a copy of the node at the end of the list (the last element)
	 * @return the last node of the list
	 */
	public SinglyLinkedNode<T> topBack(){
		if(tail.getNext()==null){
			return null;
		}
		return new SinglyLinkedNode<T>(tail.getNext());
	}
	
	/**
	 * Remove the last element in the list
	 * @return the removed element
	 */
	public SinglyLinkedNode<T> popBack(){
		if(tail.getNext()==null){
			return null;
		}
		SinglyLinkedNode<T> removed = tail.getNext();
		SinglyLinkedNode<T> node=head;
		
		//Wolking down the list in order to find the node before the last one
		while(node.getNext().getNext()!=null){
			node=node.getNext();
		}
		node.setNext(node.getNext().getNext());
		if(head.getNext()==null){
			tail.setNext(null);
		}
		else{
			tail.setNext(node);
		}
		size--;
		return removed;
	}
	
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public String toString(){
		String s="[";
		SinglyLinkedNode<T> curr=head;
		if(curr.getNext()!=null){
			curr=curr.getNext();
			s+=curr.getKey();
		}
		while(curr.getNext()!=null){
			curr=curr.getNext();
			s+=","+curr.getKey();
		}
		return s+"]";
	}
	
	/**
	 * Check whether the list contains a node having the same key as the one of the specified node
	 * @param a node or a key value
	 * @return true if the list has a node with the specified key, false otherwise
	 */
	public boolean find(Object node){
		SinglyLinkedNode<T> curr=head;
		while(curr.getNext()!=null){
			curr=curr.getNext();
			if(curr.equals(node)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Return the node with the key key
	 * @param key
	 * @return the node with the specified value key
	 */
	public SinglyLinkedNode<T> getNode(T key){
		SinglyLinkedNode<T> curr=head;
		while(curr.getNext()!=null){
			curr=curr.getNext();
			if(curr.equals(key)){
				return curr;
			}
		}
		return null;
	}
	
	/**
	 * Delete from the list the node having the same key as the one of the specified node
	 * @param node
	 */
	public void erase(SinglyLinkedNode<T> node){
		SinglyLinkedNode<T> curr=head;
		while(curr.getNext()!=null){
			if((curr.getNext().equals(node))){
				remove(curr.getNext(), curr);
				break;
			}
			curr=curr.getNext();
		}
	}
	
	private void remove(SinglyLinkedNode<T> curr, SinglyLinkedNode<T> prev) {
		if(size==1 || curr.getNext()==null){
			popBack();
		}
		else{
			prev.setNext(curr.getNext());
		}
		size--;
	}
	
	/**
	 * Insert a new node with the value key before the specified before node
	 * @param key
	 * @param before
	 */
	public void addBefore(T key, SinglyLinkedNode<T> before){
		SinglyLinkedNode<T> curr=head;
		SinglyLinkedNode<T> newNode=new SinglyLinkedNode<>(key);
		newNode.setNext(before);
		while(curr.getNext()!=null){
			if(curr.getNext().equals(before)){
				curr.setNext(newNode);
				break;
			}
			curr=curr.getNext();
		}
		size++;
	}
	
	/**
	 * Insert a new node with the value key after the specified after node
	 * @param key
	 * @param after
	 */
	public void addAfter(T key, SinglyLinkedNode<T> after){
		SinglyLinkedNode<T> newNode=new SinglyLinkedNode<>(key);
		newNode.setNext(after.getNext());
		after.setNext(newNode);
		
		size++;
		if(tail.getNext()==after){
			tail.setNext(newNode);
		}
	}
	
	/*
	 * Implement methods:
	 *  - addAfter
	 */
		
}