package com.biagio.dataStructures.LinkedList;

/**
 * Singly LinkedList node implementation
 * @author biagio
 */

public class SinglyLinkedNode<T> {
	private T key;
	private SinglyLinkedNode<T> next;
	
	public SinglyLinkedNode(T value){
		this.key=value;
		next=null;
	}
	
	public SinglyLinkedNode(){
		this.key=null;
		next=null;
	}
	
	public SinglyLinkedNode(SinglyLinkedNode<T> singlyLinkedNode){
		this.key=(T)singlyLinkedNode.getKey();
		this.next=singlyLinkedNode.getNext();
	}
	
	public T getKey(){
		return key;
	}
	
	public SinglyLinkedNode<T> getNext(){
		return next;
	}
	
	public void setKey(T key){
		this.key=key;
	}
	
	public void setNext(SinglyLinkedNode<T> singlyLinkedNode){
		next=singlyLinkedNode;		
	}
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj){
		if(obj==this)
			return true;
		if((obj.getClass() != this.getClass()))
			if(obj.getClass()!=key.getClass()){
				return false;
			}
			else{
				return this.key.equals(obj);
			}
		
		return this.key == ((SinglyLinkedNode<T>)obj).getKey();
		
	}
	
	public String toString(){
		return "[key: "+key+", next: "+((next!=null)?next.getKey():"[]")+"]";
	}
}
