import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author YOUR NAME (you@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() 
    {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() 
    {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
    public boolean add(T element) 
    {
    	Node n = new Node(element);
      
    	if (element == null)
    	{
    		return false;
    	}
    	
    	if (isEmpty())
    	{
    		front = n;
        	rear = n;
    	}
    	else
    	{
    		if (contains(element))
    		{
    			return false;
    			
    		}

    		else if (front.element.compareTo(element) > 0)
    		{
    			n.next = front;
    			front.prev = n;
    			front = n;
    		}
    		
    		else if (rear.element.compareTo(element) < 0)
    		{
    			rear.next = n;
    			n.prev = rear;
    			rear = n;
    		}
    		
    		else
    		{
    			Node p = front;
    			for (int i = 0; i < size; i++)
    			{
    				if (p.element.compareTo(element) > 0)
    				{
    					p = p.prev;
    					break;
    				}
    				p = p.next;
    			}
    			p.next.prev = n;
    			n.next = p.next;
    			p.next = n;
    			n.prev = p;
    		}
    	}
      
    	size++;
    	return true; 
   }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
    public boolean remove(T element) 
    {
    	Node p = front;
    	for (int i = 0; i < size; i++)
    	{
    		if (!p.element.equals(element))
    		{
    			p = p.next;
    		}
    	}
    	
    	if (isEmpty() || p == null)
    	{
    		return false;
    	}
    	
    	else
    	{
    		if (p.element == front.element && size == 1)
    		{
    			front = null;
    			rear = null;
    			size--;
    		}
    		
    		else if (p.element == front.element && size > 1)
    		{
    			front = front.next;
    			front.prev = null;
    			size--;
    			return true;
    		}
    		
    		else
    		{
    			p.prev.next = p.next;
    			if (p.next == null)
    			{
    				rear = p.prev;
    				p.prev.next = null;
    			}
    			
    			else
    			{
    				p.next.prev = p.prev;
    			}
    			size--;
    			return true;
    		}
    	}
    	return true;
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */
    public boolean contains(T element) 
    {
    	if (isEmpty()) 
    	{
    		return false;
    	}	
      
    	if (front == null) 
    	{
    		return false;
    	}
      
    	Node n = front;
      
    	while (n != null) 
    	{
    		if (n.element.equals(element)) 
    		{
    			return true;
    		}
    		n = n.next;
    	}
              
    	return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(Set<T> s) 
    {
    	if(size == s.size() && complement(s).size() == 0) 
    	{
    		return true;
    	}
    	
        return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(LinkedSet<T> s) 
    {     
    	if(size == s.size() && complement(s).size() == 0) 
    	{
    		return true;
    	}
    	
        return false;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(Set<T> s)
    {
    	LinkedSet<T> check = new LinkedSet<>();
    	Node n = front;
    	for (int i = 0; i < size; i++)
    	{
    		if (n != null)
    		{
    			check.add(n.element);
    		}
    		n = n.next;
    	}
    	
    	Iterator<T> itr = s.iterator();
    	while (itr.hasNext())
    	{
    		check.add(itr.next());
    	}
        return check;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(LinkedSet<T> s)
    {
    	LinkedSet<T> check = new LinkedSet<>();
    	Node n = front;
    	for (int i = 0; i < size; i++)
    	{
    		if (n != null)
    		{
    			check.add(n.element);
    		}
    		n = n.next;
    	}
    	
    	Iterator<T> itr = s.iterator();
    	while (itr.hasNext())
    	{
    		check.add(itr.next());
    	}
    	
        return check;
   
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
    public Set<T> intersection(Set<T> s) 
    {
        Node n = front;
        Set<T> returnSet = new LinkedSet<>();
        for (int i = 0; i < size; i++)
        {
        	if (s.contains(n.element))
        	{
        		returnSet.add(n.element);
        	}
        	n = n.next;
        }
        
        return returnSet;
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */
    public Set<T> intersection(LinkedSet<T> s) 
    {
    	Node n = front;
        Set<T> returnSet = new LinkedSet<>();
        for (int i = 0; i < size; i++)
        {
        	if (s.contains(n.element))
        	{
        		returnSet.add(n.element);
        	}
        	n = n.next;
        }
        
        return returnSet;
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
    public Set<T> complement(Set<T> s) 
    {
    	LinkedSet<T> check = new LinkedSet<>();
    	Node n = front;
    	for (int i = 0; i < size; i++)
    	{
    		if (!s.contains(n.element))
    		{
    			check.add(n.element);
    		}
    		n = n.next;
    	}
    	
        return check;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
    public Set<T> complement(LinkedSet<T> s) 
    {
    	LinkedSet<T> check = new LinkedSet<>();
    	Node n = front;
    	for (int i = 0; i < size; i++)
    	{
    		if (!s.contains(n.element))
    		{
    			check.add(n.element);
    		}
    		n = n.next;
    	}
        return check;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> iterator() 
    {
    	return new ascendingIterator();
    }
    
    private class ascendingIterator implements Iterator<T>
    {
    	Node current = front;
    	   
        public boolean hasNext() 
        {
           return current != null;
        }
        
        public T next() 
        {
           if (!hasNext())
           {
              throw new NoSuchElementException();
           }
           
           T result = current.element;
           current = current.next;
           return result;
        }
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() 
    {
        return new descendingIterator(rear);
    }
    
    private class descendingIterator implements Iterator<T>
    {
    	Node current;
        public descendingIterator(Node rear) 
        {
           current = rear;
        }
     
        public boolean hasNext() 
        {
           return current != null && current.element != null;
        }
     
        public T next() 
        {
        	if (!hasNext())
        	{
        		throw new NoSuchElementException();
        	}
            if(current != null) 
            {            
               T result = current.element;
               current = current.prev;
               return result;
            }
            return null;
         }
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() 
    {
       return new powerIterator(rear, size);
    }

    private class powerIterator implements Iterator<Set<T>> 
    {
       Node n;       
       int sizeIn;
       int current;
       
       public powerIterator(Node rear, int size) 
       {
          n = rear;
          sizeIn = size;
          current = 0;
        }
     
        public boolean hasNext() 
        {
            return (current < (int)Math.pow(2, sizeIn));
        }
     
        public Set<T> next() 
        {
        	if (!hasNext())
        	{
        		throw new NoSuchElementException();
        	}
        	
            Set<T> subSet = new LinkedSet<T>();
            if (current == 0)
            {
            	current++;
            	return subSet;
            }
            
            String bitstring = Integer.toBinaryString(current);
            for (int i = bitstring.length() - 1; i >= 0; i--) 
            {
                if (bitstring.charAt(i) == '1') 
                {
                	subSet.add(n.element);
                }
                n = n.prev;
            }
            current++;
            n = rear;
            return subSet;
        }   
    }
    	    


    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.

    ////////////////////
    // Nested classes //
    ////////////////////

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

}
