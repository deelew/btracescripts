package dilu.kxq.btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeMethodName;
import com.sun.btrace.annotations.Self;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-8-10
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class ProbStackFieldsOnCondition {
    static boolean started = false;

    @OnMethod(clazz = "xxxx", method = "finishRefresh")
    public static void start() {
        started = true;
    }

    @OnMethod(clazz = "xxxx", method = "/.*/")
    public static void printAll(@Self Object obj,  @ProbeMethodName Object method) {
        if (started) {
            println("WebxComponentsLoader============");
            println(method);
            printFields(obj);
        }
    }
    @OnMethod(clazz = "org.springframework.context.support.AbstractApplicationContext", method = "/.*/")
    public static void printAll2(@Self Object obj,  @ProbeMethodName Object method) {
        if (started) {
            println("AbstractApplicationContext============");
            println(method);
            printFields(obj);
        }
    }
}
