package com.gzj.tulip.load.vfs;

import org.apache.commons.lang.ArrayUtils;

import junit.framework.TestCase;
import com.gzj.tulip.load.LoadScope;

public class LoadScopeTest extends TestCase {

    public void test1() {
        LoadScope scope = new LoadScope("controllers=com.xiaonei.game", "controllers");
        assertNull(scope.getScope("applicationContext"));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.game", "com.gzj.tulip" },
                scope.getScope("controllers")));
    }

    public void test2() {
        LoadScope scope = new LoadScope("controllers=com.xiaonei.game,com.gzj.tulip.web",
                "controllers");
        assertNull(scope.getScope("applicationContext"));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.game", "com.gzj.tulip.web",
                "com.gzj.tulip" }, scope.getScope("controllers")));
    }

    public void test3() {
        LoadScope scope = new LoadScope(
                "com.xiaonei.game;applicationContext=com.xiaonei.abc", "controllers");
        assertNotNull(scope.getScope("applicationContext"));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.game", "com.gzj.tulip" },
                scope.getScope("controllers")));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.abc", "com.gzj.tulip" },
                scope.getScope("applicationContext")));
    }
}
