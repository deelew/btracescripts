package dilu.kxq.btrace;

import static com.sun.btrace.BTraceUtils.exit;
import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class MethodStackTrace {
        private static int printCount = 0;
         @OnMethod(clazz = "com.taobao.trade.timeout.notify.processor.backward.RefundCloseProcessor", method = "process")
        public static void func() {
            if(printCount++ < 10){

                        println("=======stack======");
                        jstack();
                        println("########end#########");
                }
            else 
                exit(0);
        }
}
