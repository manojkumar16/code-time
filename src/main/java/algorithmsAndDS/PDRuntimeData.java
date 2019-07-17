package algorithmsAndDS;

import java.sql.Timestamp;

public class PDRuntimeData {

    private int isAlreadyPulled;

    private Timestamp createts;

    private Timestamp expirationTimestamp;

    private String name;

    public PDRuntimeData( int isAlreadyPulled, Timestamp createts, Timestamp expirationTimestamp ) {
        this.isAlreadyPulled = isAlreadyPulled;
        this.createts = createts;
        this.expirationTimestamp = expirationTimestamp;
    }

    public int getIsAlreadyPulled() {
        return isAlreadyPulled;
    }

    public void incrementIsAlreadyPulled() {
        this.isAlreadyPulled = this.isAlreadyPulled + 1;
    }

    public Timestamp getCreatets() {
        return createts;
    }

    public Timestamp getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Pulled count --> "+isAlreadyPulled;
    }
}
