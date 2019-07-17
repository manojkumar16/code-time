package etc.junittesting;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestRunListener extends RunListener {

    Map<Description, MethodTestResult> results = new LinkedHashMap<Description, MethodTestResult>();

    @Override
    public void testStarted( Description description ) throws Exception {
        results.put( description, new MethodTestResult( description ) );
    }

    @Override
    public void testFinished( Description description ) throws Exception {
        results.get( description ).setEndTime( System.currentTimeMillis() );
    }

    @Override
    public void testFailure( Failure failure ) throws Exception {
        results.get( failure.getDescription() ).setFailure( failure );
    }

    public Map<Description, MethodTestResult> getResults() {
        return results;
    }

}