package algo.ds;

import java.lang.reflect.Field;

public class TestMethod {
    public static final String AS4_USER_EXIT_INVOCATION_FAILED = "Failed to process user-exit";

    public static final String AS4_USER_EXIT_INVOCATION_FAILED_ERROR_EXPLANATION = "Error occured while processing user exit";

    public static final String AS4_DECOMPRESSION_ATTACHMENTS_FAILED = "Error occured while decompressing attachments";

    public static final String AS4_RESPONSE_PROCESSING_FAILED = "Error occurred while processing response";

    public static String getValue( String key ) throws NoSuchFieldException, SecurityException,
        IllegalArgumentException, IllegalAccessException {

        String value = null;
        Field field = TestMethod.class.getField( key );
        value = (String) field.get( null );
        return value;
    }

}
