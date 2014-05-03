package dilu.kxq.btrace;

import static com.sun.btrace.BTraceUtils.jstack;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.startsWith;

import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

/***
 * Class<?> java.lang.ClassLoader.loadClass(String name) throws
 * ClassNotFoundException
 * 
 * @author dilu.kxq
 * 
 */
@BTrace
public class TraceClassLoadPoint {

	@OnMethod(clazz = "java.lang.ClassLoader", method = "loadClass")
	public static void func(String className) {

		if (className != null && startsWith(className, "com.taobao.forest")) {
			println("=======stack======");
			jstack();
			println("########end#########");
		}
	}
}
