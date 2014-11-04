package dilu.kxq.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-7-28
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class OnException {
    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultListableBeanFactory"
    ,method = "resolveDependency", location = @Location(Kind.THROW))
    public static void onThrow(@Self Object self) {
        BTraceUtils.println(BTraceUtils.str(BTraceUtils.classOf(self)));
        BTraceUtils.printFields(self);
        BTraceUtils.jstack();
        BTraceUtils.println("----------------");

    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultListableBeanFactory"
    ,method = "resolveDependency", location = @Location(Kind.CATCH))
    public static void onCatch(@Self Object self) {
        BTraceUtils.println(BTraceUtils.str(BTraceUtils.classOf(self)));
        BTraceUtils.printFields(self);
        BTraceUtils.jstack();
        BTraceUtils.println("----------------");
    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultListableBeanFactory"
    ,method = "resolveDependency", location = @Location(Kind.ERROR))
    public static void onError(@Self Object self) {
        BTraceUtils.println(BTraceUtils.str(BTraceUtils.classOf(self)));
        BTraceUtils.printFields(self);
        BTraceUtils.jstack();
        BTraceUtils.println("----------------");
    }
}
