package combinatorial.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Combinatorial {

	public Vector<Integer> findConsecutiveGroupofLargestSum(int[] numbers) {
		Vector<Integer> numberArray = convertIntArrayToVector(numbers);
		return findGroupOfDigitsWithMaxSum(generateGroupOfDigits(numberArray));
	}

	private Vector<Vector<Integer>> generateGroupOfDigits(Vector<Integer> numberArray) {
		Vector<Vector<Integer>> listOfGroups =  new Vector<Vector<Integer>> ();
		for(int i = 0; i<numberArray.size(); i++){
			listOfGroups.addAll(makeGroupsOfDigts(numberArray, i));
		}
		return listOfGroups;
	}

	 private Vector<Vector<Integer>> makeGroupsOfDigts(Vector<Integer> numberArray, int startOfArray) {
		Vector<Vector<Integer>> listOfGroups = new Vector<Vector<Integer>> ();
		
		if(isEndOfTheArray(numberArray, startOfArray))
				return listOfGroups;
		
		Vector<Integer> startingDigit = new Vector<Integer>();
		startingDigit.add(numberArray.get(startOfArray));
		listOfGroups.add(startingDigit);
		
		Vector<Vector<Integer>> remainingGroupOfDigits = makeGroupsOfDigts(numberArray, startOfArray+1);
		for(Vector<Integer> group: remainingGroupOfDigits){
			group.addAll(0,startingDigit);
			listOfGroups.add(group);
		}
		return listOfGroups;
	}

	private boolean isEndOfTheArray(Vector<Integer> numberArray, int startOfArray) {
		return startOfArray >= numberArray.size();
	}

	public static Vector<Integer> convertIntArrayToVector(int[] input) {
	        Vector<Integer> list = new Vector<Integer>();
	        for (int i : input) {
	            list.add(i);
	        }
	        return list;
	 }
	 
	 private Vector<Integer> findGroupOfDigitsWithMaxSum (Vector<Vector<Integer>> listOfGroups){
		 int location = 0;
		 int sum = -9999;
		 
		 int counter = 0;
		 for(Vector<Integer> group: listOfGroups){
			 	int sumofgroup = makeSumFromGroup(group); 
				if(sum < sumofgroup){
					location = counter;
					sum = makeSumFromGroup(group);
				}
				counter++;
		 }
		 
		 return listOfGroups.get(location);
	 }

	private int makeSumFromGroup(Vector<Integer> input) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : input) {
            sum += i;
        }
	    return sum;
	}
}
