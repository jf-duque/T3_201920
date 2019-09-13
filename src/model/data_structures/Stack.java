/******************************************************************************
 *  Compilation:  javac ResizingArrayBag.java
 *  Execution:    java ResizingArrayBag
 *  Dependencies: StdIn.java StdOut.java
 *  
 *  Bag implementation with a resizing array.
 *
 ******************************************************************************/

package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements IStack<Item>
{
	/**
	 * Arreglo dinamico de los elementos de la pila
	 */
	private Array<Item> pila;
	
	/**
	 * Contador de elementos
	 */
	private int contador=0;
	
	/**
	 * Constructor de la clase donde se inicializa el arreglo dinamico 
	 */
	
	public Stack()
	{
		pila = new Array<Item>();
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return pila.iterator();
	}

	@Override
	public boolean isEmpty() {
		return pila.isEmpty();
	}

	@Override
	public int size() {
		return pila.size();
	}

	@Override
	public void push(Item item) 
	{
		// TODO Auto-generated method stub
		pila.add(item);
		contador++;
	}

	@Override
	public Item pop() {
		// TODO Auto-generated method stub
		Item x= pila.get(contador-1);
		pila.remove(contador-1);
		contador--;
		return x;
	}
	
}