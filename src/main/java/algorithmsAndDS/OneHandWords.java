package algorithmsAndDS;

public class OneHandWords {
    public static String left = "qwerasdfzxcvtgb ";

    public static String right = "uiopjklmnhy ";

    public static String largestLeft( String[] words ) {
        String ret = "";
        for ( String s : words ) {
            if ( isLeft( s.toLowerCase() ) && s.length() > ret.length() ) {
                ret = s;
            }
        }
        return ret;
    }

    public static String smallestLeft( String[] words ) {
        String ret = "";
        for ( String s : words ) {
            if ( isLeft( s.toLowerCase() ) ) {
                if ( ret.length() > s.length() )
                    ret = s;
                else if ( ret.equals( "" ) )
                    ret = s;
            }
        }
        return ret;
    }

    public static String largestRight( String[] words ) {
        String ret = "";
        for ( String s : words ) {
            if ( isRight( s.toLowerCase() ) && s.length() > ret.length() ) {
                ret = s;
            }
        }
        return ret;
    }

    public static String smallestRight( String[] words ) {
        String ret = "";
        for ( String s : words ) {
            if ( isRight( s.toLowerCase() ) ) {
                if ( ret.length() > s.length() )
                    ret = s;
                else if ( ret.equals( "" ) )
                    ret = s;
            }
        }
        return ret;
    }

    public static String largestOneHandWord( String[] words ) {
        String right = largestRight( words );
        String left = largestLeft( words );
        if ( right.length() >= left.length() )
            return right;
        else
            return left;
    }

    public static String smallestOneHandWord( String[] words ) {
        String right = smallestRight( words );
        String left = smallestLeft( words );
        if ( left.length() < right.length() )
            return left;
        else
            return right;
    }

    private static boolean isLeft( String s ) {
        boolean isGood = left.contains( s.subSequence( 0, 1 ) );
        if ( s.length() < 2 && isGood ) {
            return true;
        } else if ( isGood ) {
            return isLeft( s.substring( 1 ) );
        } else
            return false;
    }

    private static boolean isRight( String s ) {
        boolean isGood = right.contains( s.subSequence( 0, 1 ) );
        if ( s.length() < 2 && isGood ) {
            return true;
        } else if ( isGood ) {
            return isRight( s.substring( 1 ) );
        } else
            return false;
    }
}
