import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Joshua Kim (jjk0027@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  1/25/21
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) 
    {
      if (a == null || a.length == 0)
    	{
    		throw new IllegalArgumentException("array must have at least 1 item");
    	}
      
    	int min = a[0];
    	for (int i = 0; i < a.length; i++)
    	{
    		if (a[i] < min)
    		{
    			min = a[i];
    		}
    	}
    		
        return min;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) 
    {
      if (a == null || a.length == 0)
    	{
    		throw new IllegalArgumentException("array must have at least 1 item");
    	}
      
    	int max = a[0];
    	for (int i = 0; i < a.length; i++)
    	{
    		if (a[i] > max)
    		{
    			max = a[i];
    		}
    	}
    		
        return max;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) 
    {
       //Arrays.sort(a);
      
       if (a == null || a.length == 0 || k > a.length)
       {
          throw new IllegalArgumentException("array must have at least 1 item");
       }
         
     	 int find = 0;
       int distinct = 0;
       int notDistinct = 0;
       int copyIndex = 0;
       
     	 int[] findArr = Arrays.copyOf(a, a.length);
       Arrays.sort(findArr);
       
       int[] copyArr = new int[findArr.length];
    	 
       for (int i = 1; i < findArr.length; i++)
       {
           if (findArr[distinct] != findArr[i])
           {
              copyArr[copyIndex] = findArr[distinct];
              distinct++;
              copyIndex++;
           }
           
           else
           {
              notDistinct++;
              distinct++;
           }
        }
        
        copyArr[copyIndex] = findArr[a.length - 1];
        distinct = distinct - notDistinct + 1;
        
        if (k > distinct)
        {
           throw new IllegalArgumentException("k is above the number of distinct items");
        }
        
        return copyArr[k - 1];
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) 
    {
        //Arrays.sort(a);
      
        if (a == null || a.length == 0 || k > a.length)
        {
           throw new IllegalArgumentException("array must have at least 1 item");
        }
         
        int find = 0;
        int distinct = 0;
        int notDistinct = 0;
        int copyIndex = 0;
       
     	  int[] findArr = Arrays.copyOf(a, a.length);
        Arrays.sort(findArr);
       
        int[] copyArr = new int[findArr.length];
    	 
        for (int i = findArr.length - 1; i >= 0; i--)
        {
            int reverse = i - 1;
            if (reverse < 0)
            {
               break;
            }
            
            if (findArr[reverse] != findArr[i])
            {
               copyArr[copyIndex] = findArr[i];
               distinct++;
               copyIndex++;
            }
           
            else
            {
               notDistinct++;
               distinct++;
            }
         }
        
         copyArr[copyIndex] = findArr[0];
         distinct = distinct - notDistinct + 1;
        
         if (k > distinct)
         {
            throw new IllegalArgumentException("k is above the number of distinct items");
         }
        
         return copyArr[k - 1];
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) 
    {
        if (a == null || a.length == 0)
        {
           throw new IllegalArgumentException("array must have at least 1 item");
        }
        
        int arrayLength = 0;
        for (int i = 0; i < a.length; i++)
        {
             if (a[i] >= low && a[i] <= high)
             {
                arrayLength++;
             }
        }
        
        int[] list = new int[arrayLength];
        int listIndex = 0;
        
        for (int i = 0; i < a.length; i++)
        {
             if (a[i] >= low && a[i] <= high)
             {
                list[listIndex] = a[i];
                listIndex++;
             }
        }
        
        return list;
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) 
    {
        if (a == null || a.length == 0)
        {
           throw new IllegalArgumentException("array must have at least 1 item");
        }
        
        int max = a[0];
    	  for (int i = 0; i < a.length; i++)
    	  {
    	      if (a[i] > max)
    	      {
    		       max = a[i];
    	      }
    	  } 
        
        int ceiling = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (ceiling == key)
            {
               break;
            }
            else if (a[i] == key)
            {
               ceiling = a[i];
               break;
            }
            else if (a[i] >= key && (Math.abs((a[i] - key)) <= Math.abs((ceiling - key))))
            {
               ceiling = a[i];
            }
        }
        
        if (key > max)
        {
           throw new IllegalArgumentException("key cannot be greater than max");
        }
        
        return ceiling;
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) 
    {
        if (a == null || a.length == 0)
        {
           throw new IllegalArgumentException("array must have at least 1 item");
        }
        
        int min = a[0];
    	  for (int i = 0; i < a.length; i++)
    	  {
    		   if (a[i] < min)
    		   {
    		   	min = a[i];
    		   }
    	  }  
        
        int floor = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (floor == key)
            {
               break;
            }
            else if (a[i] == key )
            {
               floor = a[i];
               break;
            }
            
            else if (a[i] <= key && (key - a[i] <= key - floor))
            {
               floor = a[i];
            }
        }
        
        if (key < min)
        {
           throw new IllegalArgumentException("key cannot be less than max");
        }
        
        return floor;
    }

}