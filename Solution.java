import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {

	/**
	 * Depending on the situation, the original input arrays might or might not be
	 * preserved. This is an implementation without retaining the original input
	 * arrays.
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numberOfElementsPerArray = scanner.nextInt();

		Map<Integer, Integer> ferquencyPerValue_arraA = new HashMap<Integer, Integer>();

		for (int i = 0; i < numberOfElementsPerArray; i++) {
			int element = scanner.nextInt();

			if (!ferquencyPerValue_arraA.containsKey(element)) {
				ferquencyPerValue_arraA.put(element, 1);
			} else {
				int ferquency = ferquencyPerValue_arraA.get(element);
				ferquencyPerValue_arraA.put(element, ferquency + 1);
			}
		}

		List<Integer> valuesOfPairs = new ArrayList<Integer>();

		for (int i = 0; i < numberOfElementsPerArray; i++) {
			int element = scanner.nextInt();

			if (ferquencyPerValue_arraA.containsKey(element)) {
				valuesOfPairs.add(element);
				int ferquency = ferquencyPerValue_arraA.get(element);
				if (ferquency == 1) {
					ferquencyPerValue_arraA.remove(element);
				} else {
					ferquencyPerValue_arraA.put(element, ferquency - 1);
				}
			}
		}
		scanner.close();

		/**
		 * The conditions stipulate that the value of one element in arrayB must be
		 * changed.
		 * 
		 * Thus, if the number of elements in ArrayList "valuesOfPairs" is equal to 
     		 * the number of elements per array, then the maximum possible number of 
                 * "pairwise disjoint beautiful pairs" is equal to the number of elements per array 
                 * minus one.
		 * 
		 * Otherwise the maximum possible number of "pairwise disjoint beautiful pairs"
		 * is equal to number of elements in ArrayList "valuesOfPairs" plus one.
		 */
		if (numberOfElementsPerArray == valuesOfPairs.size()) {
			System.out.println(numberOfElementsPerArray - 1);
		} else {
			System.out.println(valuesOfPairs.size() + 1);
		}
	}
}
