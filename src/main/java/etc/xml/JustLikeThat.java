package etc.xml;

public class JustLikeThat {

    public static void main( String[] args ) {
        String orig = "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/";

        String key1 = "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:priority";
        String key2 = "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/Permission";
        String res = modifyXml( orig, key1 );
    }

    private static String modifyXml( String orig, String key ) {
        String[] splittedKey = key.split( "/" );

        int ind = 0;
        
        String str = "";
        while ( orig.startsWith( str ) ) {
            str = str + splittedKey[ind++];
        }

        for ( int i = ind+1; i < splittedKey.length; i++ ) {
            orig = orig + splittedKey[i]+"/";
        }
        System.out.println( orig );
        return null;
    }

}
