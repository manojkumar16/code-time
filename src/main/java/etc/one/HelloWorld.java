package etc.one;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class HelloWorld {

    public static void main( String[] args ) throws SocketException {
        Enumeration<NetworkInterface> ni = NetworkInterface.getNetworkInterfaces();
        while ( ni.hasMoreElements() ) {
            NetworkInterface nt = ni.nextElement();
            System.out.print( "Network : " + nt );
            byte[] mac = nt.getHardwareAddress();
            if ( mac == null ) {
                System.out.println( " --> MAC Address : [" + mac + "]" );
            } else {
                StringBuilder sb = new StringBuilder();
                for ( int i = 0; i < mac.length; i++ ) {
                    sb.append( String.format( "%02X%s", mac[i], ( i < mac.length - 1 ) ? "-" : "" ) );
                }
                System.out.println( " --> MAC Address : [" + sb.toString() + "]" );
            }
        }
    }

}
