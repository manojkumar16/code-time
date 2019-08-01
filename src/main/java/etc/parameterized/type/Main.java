package etc.parameterized.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main( String[] args ) {
        // classMeth();
        // new Main().m1();
        
       // Pair<Integer, Integer>[] list = new Pair<Integer, Integer>[10];
    }

    public void m1() {
        List<Integer> list = new ArrayList<Integer>();
        list.add( 10 );

        m2( list );
    }

    private void m2( Object obj ) {
        List<String> list = (List<String>) obj;
        m3( list );
    }

    private void m3( List<String> list ) {
        String str = list.get( 0 );
    }

    private static void classMeth() {

        Class<?> klass = ClassAImpl.class;
        String clazz = null;

        Type[] types = klass.getGenericInterfaces();
        for ( Type type : types ) {
            if ( type instanceof ParameterizedType ) {
                ParameterizedType ptype = (ParameterizedType) type;
                Type tt = ptype.getActualTypeArguments()[0];

                Class<?> rawType = null;
                if ( type instanceof Class<?> ) {
                    rawType = (Class<?>) type;
                } else {
                    rawType = (Class<?>) ( (ParameterizedType) type ).getRawType();
                }

                System.out.println( "Raw type class name - " + rawType );
                clazz = tt.toString().substring( 6 );
            }
        }
        try {
            Class<?> fc = (Class<?>) Class.forName( clazz, true, klass.getClassLoader() );
            System.out.println( "Class name - " + fc.getName() );
        } catch ( ClassNotFoundException e1 ) {
            e1.printStackTrace();
        }

    }
}
