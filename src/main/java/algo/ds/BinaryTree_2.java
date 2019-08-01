package algo.ds;

public class BinaryTree_2 {
    private static int oddsum = 0;
    private static int evensum = 0;
    private static int firstLevel = 0;
    private static int maxLevel = 0;
    public static void main( String[] args ) {
        new BinaryTree_2().oddLevelAndEvenLevel();
/*        System.out.println("************************");
        new BinaryTree_2().deepestOddLevelLeaf();
        System.out.println("************************");
        new BinaryTree_2().isLeavesSameLevel();*/
    }

    /*
     * Given a a Binary Tree, find the difference between the sum of nodes at odd level and the sum of nodes at even
     * level. Consider root as level 1, left and right children of root as level 2 and so on.
     * 
     * For example, in the following tree, sum of nodes at odd level is (5 + 1 + 4 + 8) which is 18. And sum of nodes at
     * even level is (2 + 6 + 3 + 7 + 9) which is 27. The output for following tree should be 18 – 27 which is -9.
     */
/*
          5
        /   \
       2     6
     /  \     \  
    1    4     8
        /     / \ 
       3     7   9  

       */
    private void oddLevelAndEvenLevel() {
        Node root = newNode( 5 );
        root.left = newNode( 2 );
        root.right = newNode( 6 );
        root.left.left = newNode( 1 );
        root.left.right = newNode( 4 );
        root.left.right.left = newNode( 3 );
        root.right.right = newNode( 8 );
        root.right.right.right = newNode( 9 );
        root.right.right.left = newNode( 7 );

        getLevelDiff( root, true );
        int diff = oddsum - evensum;
        System.out.println( diff );
    }

    private void getLevelDiff( Node root, boolean oddflag ) {
        if ( root == null ) {
            return;
        }
        if ( oddflag ) {
            oddsum = oddsum + (int) root.key;
        } else {
            evensum = evensum + (int) root.key;
        }
        if ( root.right == null && root.left == null ) {
            return;
        }

        getLevelDiff( root.left, !oddflag );
        getLevelDiff( root.right, !oddflag );
    }

    /*
    1
  /   \
 2     3
/      /  \  
4      5    6
     \     \
      7     8
     /       \
    9         10
              /
             11
             */
    private void deepestOddLevelLeaf() {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.right.left = newNode(5);
        root.right.right = newNode(6);
        root.right.left.right = newNode(7);
        root.right.right.right = newNode(8);
        root.right.left.right.left = newNode(9);
        root.right.right.right.right = newNode(10);
        root.right.right.right.right.left = newNode(11);
        
        int max = findMaxLevel(root, 0);
        System.out.println(max);
    }

    private int findMaxLevel( Node root, int level ) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            if((level&1) == 1 ) {
                return level;
            }
        }
        return max(findMaxLevel( root.left, level+1 ), findMaxLevel( root.right, level+1 ));
    }

    private int max( int i, int j ) {
        return i > j ? i : j;
    }

    /*
  12
/    \
5       7       
/          \ 
3            1
Leaves are at same level

 12
/    \
5       7       
/          
3          
Leaves are Not at same level
*/
    private void isLeavesSameLevel() {
        instance1();
        System.out.println("----------------");
        firstLevel = 0;
        instance2();
    }

    private void instance2() {
        Node root = newNode( 12 );
        root.right = newNode( 7 );
        root.left = newNode(5);
        root.left.left = newNode(3);
        
        System.out.println( "Instance-2 should be false : " + findLeaves( root, 0 ) );
        
    }

    private void instance1() {
        Node root = newNode( 12 );
        root.right = newNode( 7 );
        root.right.right = newNode(1);
        root.left = newNode(5);
        root.left.left = newNode(3);
        
        System.out.println( "Instance-1 should be true : " + findLeaves( root, 0 ) );
    }

    private boolean findLeaves( Node root, int level ) {
        if ( root == null ) {
            return true;
        }
        if ( root.left == null && root.right == null ) {
            if(firstLevel == 0) {
                firstLevel = level;
                return true;
            } else {
                return level == firstLevel;
            }
        }
        
        return findLeaves( root.left, level+1 ) && findLeaves( root.right, level+1 );
    }

    private Node newNode( int i ) {
        Node n = new Node( i );
        n.left = null;
        n.right = null;
        return n;
    }

    private class Node<Key> {
        private Key key;
        private Node left, right; // left and right subtrees
        public Node( Key key ) {
            this.key = key;
        }
    }
}
