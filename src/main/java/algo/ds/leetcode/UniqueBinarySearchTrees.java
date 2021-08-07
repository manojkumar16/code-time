package algo.ds.leetcode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));

    }

    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; ++j) {
                G[i] = G[i] + G[j-1] * G[i-j];
            }
        }
        
        return G[n];
    }
}
