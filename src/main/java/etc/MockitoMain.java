package etc;

import java.util.LinkedList;
import static org.mockito.Mockito.*;

public class MockitoMain {

    public static void main( String[] args ) {
        
        LinkedList mockedList = mock(LinkedList.class);
        
        when(mockedList.get( 0 )).thenReturn( "first" );
        when(mockedList.get( 10 )).thenReturn( "10thObject" );
        System.out.println(mockedList.get( 0 ));
        
        System.out.println(mockedList.get( 5 ));
        System.out.println(mockedList.get( 10 ));
        
        mockedList.add( "one" );
        mockedList.add( "one2" );
        verify(mockedList).add( "one" );
        String str = (String)verify(mockedList).get( 0 );
    }

}
