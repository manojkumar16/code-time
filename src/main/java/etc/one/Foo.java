package etc.one;

public class Foo {
    @ReverseCharRecursion
    public static void m1() {
    }

    public static void m2() {
    }

    @ReverseCharRecursion
    public static void m3() {
        throw new RuntimeException( "Boom" );
    }

    public static void m4() {
    }

    @ReverseCharRecursion
    public static void m5() {
    }

    public static void m6() {
    }

    @ReverseCharRecursion
    public static void m7() {
        throw new RuntimeException( "Crash" );
    }

    public static void m8() {
    }
}
