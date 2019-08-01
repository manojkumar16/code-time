package algo.ds;

/**
Reverse the alternate level nodes of the binary tree. 
a 
/ \ 
b c 
/ \ / \ 
d e f g 
/ \ / \ / \ / \ 
h i j k l m n o 

Modified tree: 
a 
/ \ 
c b 
/ \ / \ 
d e f g 
/ \ / \ / \ / \ 
o n m l k j i h
 * 
 *
 */
public class ReverseAlternateLevel {
/**
 *
At every alternate level: 
1. Put the nodes in an array 
2. Reverse the array 
3. Put the nodes back in the tree at that level.  

http://www.careercup.com/question?id=5068704572243968
 */
    // Code is not completed yet
    public static void main( String[] args ) {
        tree root = newNode( 'a' );
        root.left = newNode( 'b' );
        root.right = newNode( 'c' );
        root.left.left = newNode( 'd' );
        root.left.right = newNode( 'e' );
        root.right.left = newNode( 'f' );
        root.right.right = newNode( 'g' );
        root.left.left.left = newNode( 'h' );
        root.left.left.right = newNode( 'i' );
        root.left.right.left = newNode( 'j' );
        root.left.right.right = newNode( 'k' );
        root.right.left.left = newNode( 'l' );
        root.right.left.right = newNode( 'm' );
        root.right.right.left = newNode( 'n' );
        root.right.right.right = newNode( 'o' );
        
        changeLevelOrder(root);
    }

    private static void changeLevelOrder( tree root ) {
        int height = height( root );
        System.out.println( height );
    }

    private static int height( tree root ) {
        if ( root == null ) {
            return 0;
        } else {
            int l = height( root.left );
            int r = height( root.right );
            if ( l > r ) {
                return l + 1;
            } else {
                return r + 1;
            }
        }
    }

    static tree newNode( char data ) {
        tree n = new tree();
        n.data = data;
        n.left = n.right = null;
        return n;
    }
}

class tree {
    char data;

    tree left, right;
}


