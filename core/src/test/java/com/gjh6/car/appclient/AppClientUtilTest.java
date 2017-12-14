package com.gjh6.car.appclient;

import com.alibaba.fastjson.JSONObject;
import com.gjh6.car.user.UserUtil;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.apache.commons.io.FileUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * AppClientUtil Tester.
 *
 * @author <Authors name>
 * @since <pre>12/14/2017</pre>
 * @version 1.0
 */
public class AppClientUtilTest extends TestCase {
    public AppClientUtilTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetInstance() throws Exception {
        //JSONObject checksoft = AppClientUtil.getInstance().checksoft();
        //System.out.println(checksoft.toJSONString());
        JSONObject checksoft = UserUtil.getInstance().getCarList();
        System.out.println(checksoft.toJSONString());
    }

    public static Test suite() {
        return new TestSuite(AppClientUtilTest.class);
    }
}
