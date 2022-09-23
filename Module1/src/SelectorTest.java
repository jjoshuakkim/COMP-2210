import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class SelectorTest 
{

	@Test
	public void minTest() 
	{
		int[] minArr = {5, 9, 1, 7, 3};
		Assert.assertEquals(1, Selector.min(minArr));
	}
	
	@Test
	public void maxTest()
	{
		int[] maxArr = {1, 2, 3, 4, 5};
		Assert.assertEquals(5, Selector.max(maxArr));
	}
	
	@Test
	public void kminTest()
	{
		int[] kminArr = {8, 2, 8, 7, 3, 3, 4};
		Assert.assertEquals(7, Selector.kmin(kminArr, 4));
	}
   
	@Test
	public void kmaxTest()
	{
		int[] kmaxArr = {5, 7};
		Assert.assertEquals(7, Selector.kmax(kmaxArr, 1));
	}
   
   @Test
   public void rangeTest()
   {
      int[] rangeArr = {2, 8, 7, 3, 4};
      Assert.assertEquals("[2, 3, 4]", Arrays.toString(Selector.range(rangeArr, 2, 4)));
   }
   
   @Test
   public void ceilingTest()
   {
      int[] floorArr = {-3, 3, 9, 7, 0};
      Assert.assertEquals(-3, Selector.ceiling(floorArr, -5));
   }
   
   @Test
   public void floorTest()
   {
      int[] floorArr = {3, 7, 1, 9, 5};
      Assert.assertEquals(1, Selector.floor(floorArr, 1));
   }
}
