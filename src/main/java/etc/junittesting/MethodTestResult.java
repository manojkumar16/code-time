package etc.junittesting;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/**
 * A class which holds test result for each test method execution
 * @author mkprasad
 *
 */
public class MethodTestResult {

    Failure failure;

    Description description;

    long startTime;

    long endTime;

    public MethodTestResult( Description description ) {
        this.description = description;
        this.startTime = System.currentTimeMillis();
    }

    public Failure getFailure() {
        return failure;
    }

    public void setFailure( Failure failure ) {
        this.failure = failure;
    }

    public Description getDescription() {
        return description;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime( long endTime ) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getExecutionTime() {
        return getEndTime() - getStartTime();
    }

    boolean wasSuccessful() {
        return failure == null;
    }
}
