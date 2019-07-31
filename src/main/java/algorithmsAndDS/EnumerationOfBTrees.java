package algorithmsAndDS;

/**
 * 
 * Graph Theory: Given n nodes, how many labeled and unlabeled binary trees and
 * binary search trees are possible?
 * 
 * 
 * Ref: https://www.youtube.com/watch?v=eoofvKI_Okg
 * https://www.quora.com/Graph-Theory-Given-n-nodes-how-many-labeled-and-unlabeled-binary-trees-and-binary-search-trees-are-possible
 * https://www.geeksforgeeks.org/enumeration-of-binary-trees/
 * 
 * @author m0k00i6
 *
 */
public class EnumerationOfBTrees {

	public static void main(String[] args) {
		int n = 3;
		int count = countTrees(n);
		System.out.println("Total number of Unlabeled binary trees: " + count);

		// Q. How many labeled Binary Trees can be there with n nodes?
		
		// A. Every unlabeled tree with n nodes can create n! different labeled trees by
		// assigning different permutations of labels to all nodes
		//Number of Labeled Tees = (Number of unlabeled trees) * n!
        //        = [(2n)! / (n+1)!n!]  × n!
		
		//int countLabeled = count * n!

	}

	private static int countTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int sum = 0, left = 0, right = 0;
		for (int i = 1; i <= n; i++) { // Look at geeksforgeeks
			left = countTrees(i - 1);
			right = countTrees(n - i);
			sum = sum + left * right;
		}
		return sum;
	}

}
