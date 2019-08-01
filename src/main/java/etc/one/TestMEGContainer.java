package etc.one;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.ibm.b2b.test.framework.TestFramework;

/**
 * Tests to check if container is in active state
 * 
 * @author mkprasad
 * 
 */
public class TestMEGContainer extends TestCase {

	/**
	 * Check if all bundles are in active state except fragments List out all
	 * bundles which is not in active state and throw exceptions in assert
	 */
	public void testContainerState() {
		Properties props = readTestFile();
		String ignoreBundlesState = props.getProperty("IgnoreBundles");
		List<String> ignoreBundlesList = new ArrayList<String>();
		if (ignoreBundlesState != null) {
			String[] str = ignoreBundlesState.split(",");
			ignoreBundlesList = Arrays.asList(str);
		}

		System.out.println("Executing testContainerState() operation");
		boolean bNotCorrectState = false;
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		BundleContext context = TestFramework.getBundleContext();
		if (context != null) {
			Bundle[] bundles = context.getBundles();
			for (int i = 0; i < bundles.length; i++) {
				Bundle bundle = bundles[i];
				int state = bundle.getState();

				String bundleName = bundle.getSymbolicName();

				// If bundle is in Ignore List, then dont check the status...
				if (ignoreBundlesList.contains(bundleName)) {
					System.out.println("The state of Bundle [" + bundleName
							+ "] is not checked.");
					continue;
				}
				// If bundle is not in ACTIVE state, check for lazy policy and
				// fragments
				if (state != 32) {
					// System.out.println( "Bundle: " + bundle.getSymbolicName()
					// );

					String fragment = (String) bundle.getHeaders().get(
							org.osgi.framework.Constants.FRAGMENT_HOST);
					String policy = (String) bundle
							.getHeaders()
							.get(org.osgi.framework.Constants.BUNDLE_ACTIVATIONPOLICY);

					if (fragment == null && policy == null) {
						bNotCorrectState = true;
						buf.append(bundleName + ",");
					}

					if (policy != null && policy.equalsIgnoreCase("lazy")
							&& state != 8) {
						bNotCorrectState = true;
						buf.append(bundleName + ",");
					}
				}
			}

			buf.append("]");

			if (bNotCorrectState) {
				assertTrue("Bundle " + buf.toString()
						+ " is not in proper state.", false);
			}
		} else {
			assertTrue("Bundle context should not be null", false);
		}

	}

	private Properties readTestFile() {
		InputStream in = null;
		String fileLoc = "/com/ibm/b2b/test/framework/test.properties";
		Properties props = new Properties();
		try {
			in = this.getClass().getClassLoader().getResourceAsStream(fileLoc);
			props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}
}
