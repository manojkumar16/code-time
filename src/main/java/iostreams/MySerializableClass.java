package iostreams;

import java.io.Serializable;

public class MySerializableClass implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7611275085177782269L;

    private String str1;

    private String str2;
    
    private String str3;

    MySerializableClass( String s1, String s2, String s3 ) {
        str1 = s1;
        str2 = s2;
        str3 = s3;
    }

    public String toString() {
        return str1 +" "+ str2 + " ---- "+str3;
    }
    
}
