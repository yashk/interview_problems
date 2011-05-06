import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Greplin3 {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, Exception {
		/*
		 * System.out.println(sum((Arrays.asList(new Integer []{1,2,3}))));
		 * System.out.println(max((Arrays.asList(new Integer []{1,2,3}))));
		 * System.out.println(isLargestNoEqualToSumOfOthers(Arrays.asList(new
		 * Integer []{2,4,6}))); System.out.println(subLists(Arrays.asList(new
		 * Integer[]{1, 2, 3, 4, 6}),2));
		 */

		List<Integer> input = Arrays.asList(new Integer[] { 1, 2, 3, 4, 6 });
		List<Integer> input2 = Arrays.asList(new Integer[] { 3, 4, 9, 14, 15,
				19, 28, 37, 47, 50, 54, 56, 59, 61, 70, 73, 78, 81, 92, 95, 97,
				99 });
		System.out.println("input size " + input2.size());
		System.out.println(noOfSubsetsWhereLargestIsEqualToSumOfOthers(input2));
		
		//System.out.println(allSubsetsOfLengthN(input2, 21).size());

	}

	private static boolean isLargestNoEqualToSumOfOthers(List<Integer> input) {
		int sum = sum(input);
		int max = max(input);

		return max == (sum - max);
	}

	private static int sum(List<Integer> input) {
		int sum = 0;
		for (int i = 0; i < input.size(); i++) {
			sum = sum + input.get(i);
		}

		return sum;
	}

	private static int max(List<Integer> input) {
		int max = -1;
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) > max) {
				max = input.get(i);
			}
		}

		return max;
	}

	private static int noOfSubsetsWhereLargestIsEqualToSumOfOthers(
			List<Integer> input) throws InterruptedException, ExecutionException {
		// int finalResult = 0;
		System.out.println("iteration count " + (input.size() - 3));
		Executor executor = Executors.newFixedThreadPool(input.size() - 3);

		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
				executor);

		for (int i = input.size() - 1; i >= 3; i--) {
			final List<List<Integer>> result = allSubsetsOfLengthN(input, i);
			System.out.println("count all subsets of length  "+ i +" " + result.size());
			completionService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int count = 0;
					for (List<Integer> list : result) {
						//System.out.print("*");
						if (isLargestNoEqualToSumOfOthers(list)) {
							count++;
						}
					}
					return count;
				}
			});

		}
		int finalResult = 0;
		for (int i = input.size() - 1; i >= 3; i--) {
			Future<Integer> indiResultFuture = completionService.take();
			Integer indiResult = indiResultFuture.get();
			finalResult = finalResult+indiResult;
			System.out.print(".");
		}
		
		return finalResult;
	}

	

	private static List<List<Integer>> allSubsetsOfLengthN(List<Integer> set,
			int r) {
		CombinationGenerator x = new CombinationGenerator(set.size(), r);
		List<Integer> combination = null;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] indices;
		while (x.hasMore()) {
			combination = new ArrayList<Integer>();
			indices = x.getNext();
			for (int i = 0; i < indices.length; i++) {
				combination.add((set.get(indices[i])));
			}
			result.add(combination);
			// System.out.println (combination.toString ());
		}
		return result;
	}
}
