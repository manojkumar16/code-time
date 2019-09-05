package algo.ds;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PullRequestPerformance {

    static List<PDRuntimeData> records = new ArrayList<PDRuntimeData>();

    private static final int MAX_PULLS = 3;

    static int tillNowCount = 0;
    static int startCount = 1000;
    static int multiple = 1;

    public static void main( String[] args ) {

        PullRequestPerformance pr = new PullRequestPerformance();
        pr.fillRecords( 10000 );
        
        System.out.println( "Total records: " + records.size() );
        long start = System.currentTimeMillis();

        //mkpp starts - 1
/*        while ( true ) {
            tillNowCount++;
            PDRuntimeData p = pr.startIterative();
            if ( p == null ) {
                System.out.println( "Processing completed." );
                return;
            }
            if ( tillNowCount == startCount * multiple ) {
                multiple++;
                displayTimeTaken( start, p );
                start = System.currentTimeMillis();
                System.out.println( "------------------------------------" );
            }
            p.incrementIsAlreadyPulled();
            p = pr.startIterative();
        }*/
        //mkpp ends - 1
        
        //mkpp starts - 2
        while ( true ) {
            tillNowCount++;
            PDRuntimeData p = pr.startTree();
            if ( p == null ) {
                System.out.println( "Processing completed." );
                return;
            }
            if ( tillNowCount == startCount * multiple ) {
                multiple++;
                displayTimeTaken( start, p );
                start = System.currentTimeMillis();
                System.out.println( "------------------------------------" );
            }
            p.incrementIsAlreadyPulled();
        }

        //mkpp ends - 2
    }

    private PDRuntimeData startTree() {
        PDRuntimeData data = records.get( 0 );
        int ind = data.getIsAlreadyPulled();
        for ( int i = 1; i < records.size(); i++ ) {
            if ( ind > records.get( i ).getIsAlreadyPulled() ) {
                // update pull count object with lesser pulled count
                ind = records.get( i ).getIsAlreadyPulled();

                // Replace old object with new one;
                data = records.get( i );
            } else if ( ind == records.get( i ).getIsAlreadyPulled() ) {
                // check create ts and replace with oldest one
                if ( data.getCreatets().after( records.get( i ).getCreatets() ) ) {
                    data = records.get( i );
                }
            } else {
                // it means ind < records.get( i ).getIsAlreadyPulled() and we already have better record so dont do
                // anything.
            }

        }
        if ( data.getIsAlreadyPulled() >= MAX_PULLS ) {
            return null;
        }
        return data;
    }

    private static void displayTimeTaken( long start, PDRuntimeData p ) {
        System.out.println( p );
        long end = System.currentTimeMillis();
        long taken = end - start;
        System.out.println( "Time taken(ms) : " + taken + " : Total Records till now : " + tillNowCount );
    }

    private void fillRecords( int size ) {
        for ( int i = 0; i < size; i++ ) {
            PDRuntimeData data = new PDRuntimeData( 0,
                new Timestamp( System.currentTimeMillis() - 100000 + i ), new Timestamp(
                    System.currentTimeMillis() + 10000000 ) );
            records.add( data );
        }
    }

    private PDRuntimeData startIterative() {
        List<PDRuntimeData>[] array = new List[MAX_PULLS];

        fill( array );
        PDRuntimeData pullDestinationRuntimeData = null;
        for ( int i = 0; i < MAX_PULLS; i++ ) {
            // if the array is empty don't do anything
            if ( array[i] != null && !array[i].isEmpty() ) {
                // for timestamp compare
                for ( int j = 0; j < array[i].size(); j++ ) {
                    // if object-to-be-returned is not set or if it was created later then the current entry, set the
                    // current entry as the object-to-be-returned
                    if ( pullDestinationRuntimeData == null
                        || array[i].get( j ).getCreatets().before( pullDestinationRuntimeData.getCreatets() ) ) {
                        pullDestinationRuntimeData = array[i].get( j );
                    }
                }

                return pullDestinationRuntimeData;
            }
        }

        return null;

    }

    private void fill( List<PDRuntimeData>[] array ) {
        for ( int i = 0; i < records.size(); i++ ) {
            PDRuntimeData tempData = records.get( i );
            if ( checkValidity( tempData ) ) {
                int count = tempData.getIsAlreadyPulled();
                if ( array[count] == null ) {
                    array[count] = new ArrayList<PDRuntimeData>();
                }
                array[count].add( tempData );
            }
        }
    }

    private boolean checkValidity( PDRuntimeData tempData ) {
        if ( tempData.getIsAlreadyPulled() >= MAX_PULLS ) {
            return false;
        }
        return true;
    }
}
