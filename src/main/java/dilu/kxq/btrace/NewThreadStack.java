package dilu.kxq.btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Self;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-8-20
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class NewThreadStack {
    @OnMethod(clazz = "java.lang.Thread", method = "init")
    public static void func(@Self Object obj ,  ThreadGroup g, Runnable target, String name,
                            long stackSize) {
        print("----------");
        println(name);
        printFields(obj);
        jstack();
    }
}
