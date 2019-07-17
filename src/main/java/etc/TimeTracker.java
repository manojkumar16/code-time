package etc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeTracker {

    public static Map<String, TimeTracker> executionTaken = new HashMap<String, TimeTracker>();

    private long execution_time;

    private long start_time;

    private long end_time;

    public TimeTracker( long stime, long etime, long extime ) {
        this.start_time = stime;
        this.end_time = etime;
        this.execution_time = extime;
    }

    public static void main( String args[] ) {
        String str = parseTime( 1290228L );
        System.out.println( str );
    }

    public long getExecutionTime() {
        return execution_time;
    }

    public long getStartTime() {
        return start_time;
    }

    public long getEndTime() {
        return end_time;
    }

    public static String parseTime( Long timeInMillis ) {
        long hr = 0;
        long min = 0;
        long sec = 0;
        long ms = 0;

        if ( timeInMillis >= 1000 ) {
            long tempSec = timeInMillis / 1000;
            ms = timeInMillis % 1000;

            if ( tempSec >= 60 ) {
                long tempMin = tempSec / 60;
                sec = tempSec % 60;

                if ( tempMin >= 60 ) {
                    hr = tempMin / 60;
                    min = tempMin % 60;
                } else {
                    return display( hr, tempMin, sec, ms );
                }
            } else {
                return display( hr, min, tempSec, ms );
            }
            return display( hr, min, sec, ms );
        } else {
            return display( hr, min, sec, timeInMillis );
        }
    }

    private static String display( long hr, long min, long sec, long timeInMillis ) {
        return hr + ":" + min + ":" + sec + ":" + timeInMillis;
    }

    public String parseDate( Long time ) {
        /*
         * Date d = new Date( time );
         * 
         * String dateString = d.toString(); System.out.println("Simple date:"+dateString);
         * 
         * //SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss:SSS zzz yyyy"); SimpleDateFormat format
         * = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:SSS zzz");
         * 
         * System.out.println("After format: " + format.format(d));
         */
        Date d = new Date( time );
        SimpleDateFormat format = new SimpleDateFormat( "yyyy.MM.dd HH:mm:ss:SSS zzz" );
        String parsedDate = format.format( d );
        return parsedDate;

    }

    private static double truncate( double value ) {
        double multiplier = Math.pow( 10, 2 );
        return Math.floor( multiplier * value ) / multiplier;
    }
}
