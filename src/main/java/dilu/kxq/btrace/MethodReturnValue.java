package dilu.kxq.btrace;

import com.sun.btrace.BTraceUtils;
import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-7-28
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class MethodReturnValue {

    @OnMethod(clazz = "ch.qos.logback.classic.Logger"
            , method = "/.*/"
            , location = @Location(Kind.RETURN))
    public static void printReturn(@Return ch.qos.logback.core.spi.FilterReply obj,
                                   org.slf4j.Marker marker, ch.qos.logback.classic.Logger logger
                                    ,ch.qos.logback.classic.Level level,  String format,
                                   Object[] params,  Throwable t) {
        print("level ");
        println(level);
        print("reply "); printFields();
        print(obj);
//        BTraceUtils.jstack();
        BTraceUtils.println("------------------------------------");
    }
}
