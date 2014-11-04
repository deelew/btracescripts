package dilu.kxq.btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.Self;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-7-28
 * Time: 上午11:16
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class PrintFields {

    @OnMethod(clazz = "xxxx",method = "init" )
    public static void print(@Self Object self){
        BTraceUtils.println(BTraceUtils.str(BTraceUtils.classOf(self)));
        BTraceUtils.printFields(self);
        BTraceUtils.jstack();
        BTraceUtils.println("----------------");
    }

    @OnMethod(clazz = "xxx",method = "init" )
    public  static void printset(String name){
        BTraceUtils.println(name);
    }
}
