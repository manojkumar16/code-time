package etc;
class Base {
    public void fun() {
        System.out.println( "Base fun" );
    }
}

class Derived extends Base {
    private void fun() {
        System.out.println( "Derived fun" );
    }

    public static void main( String[] args ) {
        Base obj = new Derived();
        obj.fun();
    }
}
