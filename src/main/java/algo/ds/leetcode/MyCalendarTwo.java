package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/my-calendar-ii/
 * 
 * @author m0k00i6
 *
 */
public class MyCalendarTwo {

    List<int[]> oneBooking = new ArrayList<>();
    List<int[]> twoBooking = new ArrayList<>();

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {

        // Check if it overlaps with twoBooking
        for (int[] is : twoBooking) {
            if (start < is[1] && end > is[0]) { // overlap on 2nd booking. fail it.
                return false;
            }
        }

        // Check if it overlaps with oneBooking
        for (int[] is : oneBooking) {
            if (start < is[1] && end > is[0]) { // overlap on 1st booking
                // Move to twoBooking
                twoBooking.add(new int[] {Integer.max(start, is[0]), Integer.min(end, is[1])});
            }
        }

        oneBooking.add(new int[] {start, end});

        return true;
    }

}
