package dilu.kxq.btrace;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import static com.sun.btrace.BTraceUtils.*;
/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-5-20
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class TraceDirectBufferAllocate {
    private static int printCount = 0;
    @OnMethod(clazz = "java.nio.ByteBuffer", method = "allocateDirect")
    public static void func(int size) {
        if(printCount++ < 10){

            println("=======stack======");
            println(concat("bufferSize=", str(size)));
            jstack();
            println("########end#########");
        }
        else
            exit(0);
    }
}