package iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainSerialization {

    public static void main( String[] args ) {
        String filename = "temp.txt";

        // Object serialization
        Serialize( filename );

        // Object deserialization
        Deserialize( filename );
    }


    private static void Serialize( String filename ) {
        try {
            System.out.println( "Serialization starts..." );
            PersistentAnimation pa = new PersistentAnimation(2);
            FileOutputStream fos = new FileOutputStream( filename );
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            oos.writeObject( pa );
            oos.flush();
            oos.close();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void Deserialize( String filename ) {
        System.out.println( "Deserialization starts..." );
        PersistentAnimation obj = null;
        try {
            FileInputStream fis = new FileInputStream( filename );
            ObjectInputStream ois = new ObjectInputStream( fis );
            obj = (PersistentAnimation) ois.readObject();
            ois.close();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }

}
