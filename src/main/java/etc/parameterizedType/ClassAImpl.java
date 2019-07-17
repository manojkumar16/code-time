package etc.parameterizedType;

public class ClassAImpl extends SuperClassA implements ClassA<TClassA, UClassA>, ClassB<TClassB> {

    private String msg;

    ClassAImpl( String str ) {
        this.msg = str;
    }

    @Override
    public void displayClassA( TClassA objT, UClassA objU ) {
        System.out.println( "In class ClassAImpl - displayClassA - obj:" + objT + ", " + objU );
    }

    @Override
    void displaySuperClassAMethod() {
        System.out.println( "In class ClassAImpl - displaySuperClassAMethod" );
    }

    @Override
    public void displayClassB( TClassB obj ) {
        System.out.println( "In class ClassAImpl - displayClassB obj:" + obj );

    }

}
