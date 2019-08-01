package etc.one;

//http://www.talentbuddy.co/challenge/52a9121cc8a6c2dc91481f90521ea7a14af0110af382be3f
public class MyClass {

	public static void main(String[] args) {
		pour_water(6, 10, 3);
		System.out.println("-------------------------------------------");
		pour_water(1,5,3);
		System.out.println("-------------------------------------------");
		pour_water(3,6,4);
		
		System.out.println("--------------");
		pour_water(4, 8, 7);
		/**
		 * fill B
pour B into A
fill B
pour B into A
empty A
pour B into A
fill B
pour B into A
empty A
pour B into A
fill B
pour B into A
		 */
	}

	public static void pour_water(int l, int ca, int cb) {
		int fa = 0;
		int fb = 0;
		StringBuilder sb = new StringBuilder();
		if (l < 0 || (ca < l && cb < l)) {
			System.out.println("impossible");
			return;
		}
		if (ca == l) {
			sb.append("fill A");
			System.out.println(sb.toString());
			return;
		} else if (cb == l) {
			sb.append("fill B");
			System.out.println(sb.toString());
			return;
		}
		while (fa <= ca && fb <= cb) {
			if (ca > cb) {
				// pour water into cb and then
				// move water from cb to ca
				if((fa+cb)>ca){
					fb = fb + (fa + cb - ca);
				}
				fa = fa + cb;
				sb.append("fill B\npour B into A\n");
				if (fa == l || fb==l) {
					System.out.println(sb.toString());
					return;
				}
			} else if (ca < cb) {
				// pour water into ca and then
				// move water from ca to cb
				if((fb+ca)>cb){
					fa = fa + (fb + ca - cb);
				}
				fb = fb + ca;
				sb.append("fill A\npour A into B\n");
				if (fb == l || fa==l) {
					System.out.println(sb.toString());
					return;
				}
			} else {
				sb = new StringBuilder("impossible");
				System.out.println(sb.toString());
				return;
			}
		}
		sb = new StringBuilder("impossible");
		System.out.println(sb.toString());
		return;
	}
}
