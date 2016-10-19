package com.biagio.dataStructures.testing;

import com.biagio.dataStructures.Arrays.DynamicArray;

/**
 * The testing class for the Array implementations
 * @author biagio
 */
public class ArraysMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Testing Array");
		DynamicArray<Integer> array=new DynamicArray<Integer>(2);
		
		//ADD ITEM
		array.add(4);
		array.add(3);
		array.add(7);
		System.out.println("size: "+array.getSize());
		array.set(2, 16);
		System.out.println(array.get(2));
		
		
		//REMOVE ITEM
		array.remove(0);
		System.out.println("size: "+array.getSize());
		System.out.println(array.toString());
		
	}

}
