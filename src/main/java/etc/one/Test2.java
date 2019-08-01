package etc.one;

public class Test2 {

    public static void main( String[] args ) {
         new Test2().process();
         
         String str = "ABC"; //ABC
         String[] arr = new String[1];
         arr[0] = str; //ABC
         System.out.println(str + "    " + arr[0]); // ABC  ABC
         concatenate(str, arr);
         System.out.println(str + "    " + arr[0]); // ABC //Shura: arr? //arr[0] = ?

    }

    private static void concatenate( String str, String[] arr ) {
        str = str + arr[0]; // ABCABC
        arr[0] = str; // ABC → ABCABC //Shura: arr[0]  = “ABCABC”
        arr = new String[1]; // Shura: arr = {null} => arr[0] = null
        arr[0] = ""; // “” //Shura: arr[0]  = “‘
        
    }

    private void process() {
        
    }

}
