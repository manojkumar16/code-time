package etc;
public class MinimalExample {
    private interface Node {
        public static final Node EMPTY_NODE = new Node() {
            @Override
            public String getValue() {
                return "";
            }

            @Override
            public boolean containsChildValue( char c ) {
                return false;
            }

            @Override
            public Node getChild( char c ) {
                return this;
            }
        };

        public String getValue();

        public boolean containsChildValue( char c );

        public Node getChild( char c );
    }

    public Node findValue( Node startNode, String value ) {
        Node current = startNode;
        for ( char c : value.toCharArray() ) {
            if ( current.containsChildValue( c ) ) {
                current = current.getChild( c );
            } else {
                current = Node.EMPTY_NODE;
                break;
            }
        }
        return current;
    }
}