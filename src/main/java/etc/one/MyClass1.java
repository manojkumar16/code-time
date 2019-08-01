package etc.one;

public class MyClass1 {

    public static void main( String[] args ) {
//        Integer[] a = { 3, 2, 1, 4, 5, 7, 6, 9, 8 };
//        Integer s = 30;
//        MyClass.tuple_sum( a, s );
        //MyClass.copy_string( "abcdefghi", "xyz", 3 );
      
        //Integer[] v = {5,4,1,2};
        //find_missing_number(v);
        
      //  Integer[] v = {6, 8, 8, 7, 2, 5};
      //  max_prod(v);
        
     //   Integer[] v = { 9, 7, 8, 2, 5, 5, 8, 7 };
     //   longest_improvement( v );
        
     //   String s ="(()())";// "(())())";
     //   balanced_brackets(s);
        
        Integer[] numbers = { 9, 7, 8, 2, 5, 5, 8, 7 };
        sort_students(numbers);
    }

    private static void sort_students( Integer[] numbers ) {
        for ( int i = 0; i < numbers.length; i++ ) {
            boolean done = true;
            for ( int j = 1; j < numbers.length; j++ ) {
                if ( numbers[j - 1] > numbers[j] ) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                    done = false;
                }
            }
            if ( done ) {
                break;
            }
        }
        for ( int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[i] + " " );
        }
    }

    private static void balanced_brackets( String s ) {
        int open = 0, close = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            if ( close > open ) {
                break;
            } else if ( s.charAt( i ) == '(' ) {
                open++;
            } else {
                close++;
            }
        }
        if ( open != close ) {
            System.out.println( "Unbalanced" );
        } else {
            System.out.println( "Balanced" );
        }
    }

    // http://www.talentbuddy.co/challenge/52a9121cc8a6c2dc91481f8d51ce446a4af0110af382634b
    private static void longest_improvement( Integer[] grades ) {
        int sp1 = 0, ep1 = 0, sp2 = 0, ep2 = 0;
        for ( int i = 1; i < grades.length; i++ ) {
            if ( grades[i] < grades[i - 1] ) {
                // start pointer2
                if ( ( ep2 - sp2 ) > ( ep1 - sp1 ) ) {
                    sp1 = sp2;
                    ep1 = ep2;

                    sp2 = ep2 = i;
                } else { // reset sp2 and ep2 with new index.
                    sp2 = i;
                    ep2 = i;
                }
            } else {
                ep2 = i;
            }
        }
        System.out.println( ( ep2 - sp2 ) > ( ep1 - sp1 ) ? ep2 - sp2 + 1 : ep1 - sp1 + 1 );
    }

    private static void max_prod( Integer[] v ) {
        int max = 0;
        int max_divisible_by_3_so_far = 0;
        int max_div_ind = -1;
        for ( int i = 0; i < v.length; i++ ) {
            if ( v[i] % 3 == 0 && v[i] > max_divisible_by_3_so_far ) {
                max_divisible_by_3_so_far = v[i];
                max_div_ind = i;
            }
            if ( max_div_ind != i && v[i] > max ) {
                max = v[i];
            }
        }
        System.out.println( max * max_divisible_by_3_so_far );
    }

    private static void find_missing_number( Integer[] v ) {
        int n = v.length+1;
        int expected_sum = n*(n+1)/2;
        int found_sum = 0;
        for(int i=0; i<v.length; i++){
            found_sum+=v[i];
        }
        int missing_num = expected_sum-found_sum;
        System.out.println(missing_num);
    }

    public static void copy_string(String s1, String s2, Integer p) {
        System.out.println( s1.substring( 0, p ) + s2 + s1.substring( p ) );
    }
    // http://www.talentbuddy.co/challenge/52a9121cc8a6c2dc91481f8f51fa95234af0110af38285cb
    public static void tuple_sum( Integer[] a, Integer s ) {
        solution1( a, s );
        // solution2(a,s);
    }

    private static void solution2( Integer[] a, Integer s ) {
        for ( int i = 0; i <= a.length - 4; i++ ) {
            printTriplet( i, a, s - a[i] );
        }
    }

    private static void printTriplet( int ind, Integer[] a, int s ) {
        for ( int i = ind + 1; i <= a.length - 3; i++ ) {
            printDuplex( ind, i, a, s - a[i] );
        }
    }

    private static void printDuplex( int ind1, int ind2, Integer[] a, int s ) {

    }

    // brute force
    private static void solution1( Integer[] a, Integer s ) {
        for ( int i = 0; i <= a.length - 4; i++ ) {
            if ( a[i] < s ) {
                for ( int j = i + 1; j <= a.length - 3; j++ ) {
                    if ( ( a[i] + a[j] ) < s ) {
                        for ( int k = j + 1; k <= a.length - 2; k++ ) {
                            if ( ( a[i] + a[j] + a[k] ) < s ) {
                                for ( int l = k + 1; l <= a.length - 1; l++ ) {
                                    if ( s.equals( a[i] + a[j] + a[k] + a[l] ) ) {
                                        System.out.print( i + " " + j + " " + k + " " + l );
                                        return;
                                    }
                                }

                            }
                        }

                    }
                }

            }
        }
    }
}
