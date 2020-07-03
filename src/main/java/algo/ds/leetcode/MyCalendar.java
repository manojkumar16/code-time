package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/my-calendar-i/
 
 new event: [31,34)
 
            [10,20]
                |
               / \
              /   \
           [5,8]   [25,30]    - floor key = 25(prev)
                      |
                     /  \
                    /    \
                [21,24]  [38,45] - ceiling key = 38(next)


 * @author m0k00i6
 *
 */
public class MyCalendar {
    List<int[]> oneBooking = new ArrayList<>(); // for bookBruteForce method
    
    TreeMap<Integer, Integer> calendar = new TreeMap<>(); // for bookBinarySearchTree method
    
    public MyCalendar() {
        
    }

    public boolean bookBinarySearchTree(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);

        // calendar.get(prev) = get([25,30]) = 30
        // if new event(node) falls in between or before or end then this event can be added and
        // won't cause double booking.
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
    
    public boolean bookBruteForce(int start, int end) {
        // Check if it overlaps with oneBooking
        for (int[] is : oneBooking) {
            if (start < is[1] && end > is[0])
                return false;
        }
        oneBooking.add(new int[] {start, end});
        return true;
    }
}
