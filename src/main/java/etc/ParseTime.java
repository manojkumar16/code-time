package etc;

public class ParseTime {

    public static void main( String[] args ) throws InterruptedException {
        long timeInMillis = 3680986;
        System.out.println(timeInMillis);
        String str = getTime(timeInMillis);
        
        System.out.println(str);
    }

    private static String getTime( long timeInMillis ) {
        long hr=0;
        long min=0;
        long sec=0;
        long ms=0;
        
        if(timeInMillis >= 1000) {
            long tempSec = timeInMillis/1000;
            ms = timeInMillis%1000;
            
            if(tempSec >= 60) {
                long tempMin = tempSec/60;
                sec = tempSec%60;
                
                if(tempMin >=60 ) {
                    hr = tempMin/60;
                    min = tempMin%60;
                } else {
                    return display( hr, tempMin, sec, ms );
                }
            } else {
                return display( hr, min, tempSec, ms );
            }
            return display( hr, min, sec, ms );
        } else {
            return display(hr,min,sec,timeInMillis);
        }
    }

    private static String display( long hr, long min, long sec, long timeInMillis ) {
        return hr+":"+min+":"+sec+":"+timeInMillis;
    }
}
