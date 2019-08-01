package etc.one;

public enum AggregatedState {

    STARTED,
    PARTIAL,
    FAILED;

    public String value() {
        return name();
    }

    public static AggregatedState fromValue(String v) {
        return valueOf(v);
    }

}