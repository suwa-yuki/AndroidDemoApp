package jp.classmethod.sample.demoapp;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    public void test_getAppNameのテスト() {
        String appName = getContext().getString(R.string.app_name);
        assertNotNull(appName);
        assertEquals("DemoApp", appName);
    }
}