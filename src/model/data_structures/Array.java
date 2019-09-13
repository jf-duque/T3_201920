package model.data_structures;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/******************************************************************************
 *  Compilation:  javac ResizingArrayBag.java
 *  Execution:    java ResizingArrayBag
 *  Dependencies: StdIn.java StdOut.java
 *  
 *  Bag implementation with a resizing array.
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *  The {@code ResizingArrayBag} class represents a bag (or multiset) of 
 *  generic items. It supports insertion and iterating over the 
 *  items in arbitrary order.
 *  <p>
 *  This implementation uses a resizing array.
 *  See {@link LinkedBag} for a version that uses a singly linked list.
 *  The <em>add</em> operation takes constant amortized time; the
 *  <em>isEmpty</em>, and <em>size</em> operations
 *  take constant time. Iteration takes time proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Array<Item> implements Iterable<Item>, Comparable<Item> {
<<<<<<< HEAD
	protected transient int modCount = 0;
=======
>>>>>>> 7dfe6146adb2549137fc7e9264be585fb12cfd76
    private Item[] a;         // array of items
    private int n;            // number of elements on bag

    /**
     * Initializes an empty bag.
     */
    public Array() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }

    /**
     * Adds the item to this bag.
     * @param item the item to add to this bag
     */
    public void add(Item item) {
        if (n == a.length) resize(2*a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    }
    public Item remove(int index)     
    {
    	Objects.checkIndex(index, n);
    	final Object[] es = a;
    	
    	@SuppressWarnings("unchecked") Item oldValue = (Item) es[index];
    	fastRemove(es, index);
    	
    	return oldValue;
    }
    
    
    private void fastRemove(Object[] es, int index) 
    {
    	modCount++;
    	final int newSize;
    	if ((newSize = n - 1) > index)
    		System.arraycopy(es, index + 1, es, index, newSize - index);
    	es[n = newSize] = null;
    }


    /**
     * Returns an iterator that iterates over the items in the bag in arbitrary order.
     * @return an iterator that iterates over the items in the bag in arbitrary order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        int cursor;
        int lastRet=-1;
        int  expectedModCount = modCount;
        public boolean hasNext()  { return i < n;                               }
        public void remove() {
        	if (lastRet < 0)
        		throw new IllegalStateException();
        	checkForComodification();
        	
        	try {
        		Array.this.remove(lastRet);
        		cursor = lastRet;
        		lastRet = -1;
        		expectedModCount = modCount;
        	} catch (IndexOutOfBoundsException ex) {
        		throw new ConcurrentModificationException();
        	}
        }
        
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
        public Item next() {
        	if (!hasNext()) throw new NoSuchElementException();
        	return a[i++];
        }
}
        
    
    public Item get(int p)
    {
    	Iterator iter = iterator();
    	Item actual = null;
    	int  i = 0;
    	if(p == i)
    	{
    		return (Item) iter.next();
    	}
    	while(iter.hasNext())
    	{
    		if(p == i)
    		{
    			actual = (Item)iter.next();
        		i++;
    		}
    		
    	}
    	return actual;
    }
    
    public Item get(int p)
    {
    	Iterator iter = iterator();
    	Item actual = null;
    	int  i = 0;
    	if(p == i)
    	{
    		return (Item) iter.next();
    	}
    	while(iter.hasNext())
    	{
    		if(p == i)
    		{
    			actual = (Item)iter.next();
        		i++;
    		}
    		
    	}
    	return actual;
    }

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

/******************************************************************************
 *  Copyright 2002-2018, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/