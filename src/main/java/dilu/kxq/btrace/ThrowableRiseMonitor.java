package dilu.kxq.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-8-21
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class ThrowableRiseMonitor {
    @OnMethod(clazz = "java.lang.Throwable"
            ,method = "<init>")
    public static void onThrow(@Self Object self) {
        BTraceUtils.println(BTraceUtils.str(BTraceUtils.classOf(self)));
        BTraceUtils.jstack();
        BTraceUtils.println("=============================");
    }
}
