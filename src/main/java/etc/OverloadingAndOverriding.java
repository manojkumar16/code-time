package etc;

public class OverloadingAndOverriding {

    public void f1() {

    }

    public int f2() {
        return 1;
    }

    public void f3() {

    }

    public int f3( int a ) {
        return 2;
    }

    public int f3( int a, int b ) {
        return 2;
    }

    public int f3( float a ) {
        return 2;
    }
}
