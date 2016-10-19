package com.biagio.dataStructures.Arrays;

import java.util.Arrays;
import java.util.Dictionary;

/**
 * Custom implementation of a dynamic array
 * @author biagio
 */
public class DynamicArray<T> {
	private int size;
	private int capacity;
	private Object[] arr;
	
	public DynamicArray(){
		this(16);
	}
	
	public DynamicArray(int initialCapacity){
		capacity=initialCapacity;
		arr=new Object[capacity];
	}
	
	public int getSize(){
		return size;
	}
	

	@SuppressWarnings("unchecked")
	public T get(int index) throws IndexOutOfBoundsException{
		if(checkBounds(index)){
			return (T)arr[index];
		}
		throw new IndexOutOfBoundsException("size is: "+size);
	}
	
	public void set(int index, T val) throws IndexOutOfBoundsException{
		if(checkBounds(index)){
			arr[index]=val;
		}
		else
			throw new IndexOutOfBoundsException("size is: "+size);
	}
	
	public void add(T val){
		checkCapacity();
		arr[size++]=val;
	}
	
	public void remove(int index) throws IndexOutOfBoundsException{
		if(checkBounds(index)){
			T k=null;
			for(int i=index; i<size; i++){
				arr[i]=arr[i+1];
			}
			arr[size--]=null;
		}
		else{
			throw new IndexOutOfBoundsException("size is: "+size);
		}
	}
	
	
	public String toString(){
		String s="[";
		for(int k=0; k<size-1; k++){
			s+=arr[k]+", ";
		}
		return s+arr[size-1]+"]";
		
	}
	
	private boolean checkBounds(int index){
		return index<size && index>=0;
	}
	
	private void checkCapacity(){
		if(size==capacity){
			ensureCapacity();
		}
	}
	private void ensureCapacity() {
		ensureCapacity(capacity*2);
	}
	
	public void ensureCapacity(int newCapacity){
		if(newCapacity>capacity){
			arr=Arrays.copyOf(arr, newCapacity);
			capacity=newCapacity;
		}
	}
}
