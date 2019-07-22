package combinatorial.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Combinatorial {

	public Vector<Integer> findConsecutiveSequenceWithLargestSum(int[] numbers) {
		Vector<Integer> numberArray = convertIntArrayToVector(numbers);
		return findTheSequenceWithLargestSum(generateSequencesOfDigits(numberArray));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	//This is where all the private functions are available.
	private Vector<Vector<Integer>> generateSequencesOfDigits(Vector<Integer> numberArray) {
		Vector<Vector<Integer>> listOfSequences =  new Vector<Vector<Integer>> ();
		for(int startLocation = 0; startLocation<numberArray.size(); startLocation++){
			
			listOfSequences.addAll(makeConsecutiveSequnceOfDigitsFromGivenListOfDigits(numberArray, startLocation));
		}
		return listOfSequences;
	}

	 private Vector<Vector<Integer>> makeConsecutiveSequnceOfDigitsFromGivenListOfDigits(Vector<Integer> numberArray, int startOfLocation) {
		Vector<Vector<Integer>> listOfPossibleSequences = new Vector<Vector<Integer>> ();
		
		if(isIndexAtTheEndOfSequence(numberArray, startOfLocation))
				return listOfPossibleSequences;
		
		Vector<Integer> startingSequence = new Vector<Integer>();
		startingSequence.add(numberArray.get(startOfLocation));
		listOfPossibleSequences.add(startingSequence);
		
		Vector<Vector<Integer>> remainingGroupOfSequences = makeConsecutiveSequnceOfDigitsFromGivenListOfDigits(numberArray, startOfLocation+1);
		for(Vector<Integer> sequence: remainingGroupOfSequences){
			sequence.addAll(0,startingSequence);
			listOfPossibleSequences.add(sequence);
		}
		return listOfPossibleSequences;
	}

	private boolean isIndexAtTheEndOfSequence(Vector<Integer> numberArray, int index) {
		return index >= numberArray.size();
	}

	public static Vector<Integer> convertIntArrayToVector(int[] input) {
	        Vector<Integer> list = new Vector<Integer>();
	        for (int i : input) {
	            list.add(i);
	        }
	        return list;
	 }
	 
	 private Vector<Integer> findTheSequenceWithLargestSum (Vector<Vector<Integer>> listOfSequences){
		 int locationofsequencewithlargestsum = 0;
		 int largestsumofsequence = -9999;
		 
		 int location = 0;
		 for(Vector<Integer> group: listOfSequences){
			 	int sumthesequence = sumTheSequence(group); 
				if(largestsumofsequence < sumthesequence){
					locationofsequencewithlargestsum = location;
					largestsumofsequence = sumthesequence;
				}
				location++;
		 }
		 
		 return listOfSequences.get(locationofsequencewithlargestsum);
	 }

	private int sumTheSequence(Vector<Integer> sequence) {
		int sumofsequence = 0;
		for (int numberInSequence : sequence) {
            sumofsequence += numberInSequence;
        }
	    return sumofsequence;
	}
}
