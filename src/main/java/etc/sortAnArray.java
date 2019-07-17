package etc;

public class sortAnArray {

    public static void main( String[] args ) {
        int[] a = new int[]{10, -10, 100, -100, 1000, -1000};
        
        sort(0, a.length, a);
        
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }

    private static void sort(int start, int end, int[] array) {
        int temp;
        for (int i = start + 1; i < end; i++) {
            for (int j = i; j > start && array[j - 1] > array[j]; j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }
}
