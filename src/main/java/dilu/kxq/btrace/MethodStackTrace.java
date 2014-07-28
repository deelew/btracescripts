package dilu.kxq.btrace;

import static com.sun.btrace.BTraceUtils.exit;
import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class MethodStackTrace {
        @OnMethod(clazz = "com.taobao.trade.timeout.notify.processor.backward.RefundCloseProcessor", method = "process")
        public static void func() {
            
                println("=======stack======");
                jstack();
                println("########end#########");
        
        }
}
