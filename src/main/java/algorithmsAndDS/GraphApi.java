package algorithmsAndDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphApi {
	// 2nd argument is key and later arguments will be list of adjacent nodes to key
	public Map<Integer, List<Integer>> buildGraph() {
		Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
		hm.put(0, Arrays.asList(1, 5));
		hm.put(2, Arrays.asList(0, 3));
		hm.put(3, Arrays.asList(2, 5));
		hm.put(4, Arrays.asList(2, 3));
		hm.put(5, Arrays.asList(4));
		hm.put(6, Arrays.asList(0, 4, 9, 8));
		hm.put(7, Arrays.asList(6, 9));
		hm.put(8, Arrays.asList(6));
		hm.put(9, Arrays.asList(10, 11));
		hm.put(10, Arrays.asList(12));
		hm.put(11, Arrays.asList(12));
		hm.put(12, Arrays.asList(9));

		hm.put(1, new ArrayList<Integer>());

		// buildNode( hm, 0, 1, 5 );
		// buildNode( hm, 6, 0, 4, 9, 8 );

		return hm;
	}

	// private void buildNode( Map<Integer, List<Integer>> hm, int key, Integer...
	// nodes ) {
	// hm.put( key, Arrays.asList(nodes) );
	// }
}
