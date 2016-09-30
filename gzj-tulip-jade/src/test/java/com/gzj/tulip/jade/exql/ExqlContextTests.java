package com.gzj.tulip.jade.exql;

import java.util.Date;

import com.gzj.tulip.jade.statement.expression.ExqlContext;
import com.gzj.tulip.jade.statement.expression.impl.ExqlContextImpl;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ExqlContextTests extends TestCase {

    public void testExqlContext() {

        Date current = new Date();

        ExqlContext context = new ExqlContextImpl();

        context.fillText("WHERE uid = ");
        context.fillValue(102);
        context.fillText(" AND sid IN (");
        context.fillValue(new int[] { 11, 12, 24, 25, 31, 32, 33 });
        context.fillText(") AND (create_time > ");
        context.fillValue(current);
        context.fillText(" OR create_time <= ");
        context.fillValue(current);
        context.fillChar(')');

        Assert.assertEquals( // NL
                "WHERE uid = ? AND sid IN (?,?,?,?,?,?,?) "
                        + "AND (create_time > ? OR create_time <= ?)", // NL
                context.flushOut());

        Object[] expectArray = new Object[] { 102, 11, 12, 24, 25, 31, 32, 33, // NL
                current, current };
        Object[] paramArray = context.getArgs();

        Assert.assertEquals(expectArray.length, paramArray.length);
        for (int i = 0; i < expectArray.length; i++) {
            Assert.assertEquals(expectArray[i], paramArray[i]);
        }
    }
}
