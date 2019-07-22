package combinatorial.group;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Test;

public class CombinatorialNumbersShould {

	@Test
	public void return_array_of_large_positive_sum_of_numbers() {
		Combinatorial combinatorial = new Combinatorial();
		
		Vector<Integer> numbers = combinatorial.findConsecutiveSequenceWithLargestSum(new int[]{1});
		assert(numbers.equals(Combinatorial.convertIntArrayToVector(new int[]{1})));
		
		numbers = combinatorial.findConsecutiveSequenceWithLargestSum(new int[]{2,1});
		assert(numbers.equals(Combinatorial.convertIntArrayToVector(new int[]{2,1})));

		
		numbers = combinatorial.findConsecutiveSequenceWithLargestSum(new int[]{1,-1});
		assert(numbers.equals(Combinatorial.convertIntArrayToVector(new int[]{1})));

		numbers = combinatorial.findConsecutiveSequenceWithLargestSum(new int[]{2,1,-1});
		assert(numbers.equals(Combinatorial.convertIntArrayToVector(new int[]{2,1})));
		

		numbers = combinatorial.findConsecutiveSequenceWithLargestSum(new int[]{2,1,4,-4,4});
		assert(numbers.equals(Combinatorial.convertIntArrayToVector(new int[]{2,1,4})));

		numbers = combinatorial.findConsecutiveSequenceWithLargestSum(new int[]{2, -8, 3, -2, 4, -10});
		assert(numbers.equals(Combinatorial.convertIntArrayToVector(new int[]{3, -2, 4})));
		
		assert((5 | 2) == 7);
		
	}
	
	

}
