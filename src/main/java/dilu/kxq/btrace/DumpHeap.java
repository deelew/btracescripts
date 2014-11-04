package dilu.kxq.btrace;

import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-7-28
 * Time: 上午11:41
 * To change this template use File | Settings | File Templates.
 */
public class DumpHeap {
    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultListableBeanFactory", method = "findAutowireCandidates")
    public static void dump(String beanName,Class type,org.springframework.beans.factory.config.DependencyDescriptor desc){
        if(compareTo("xxxx",beanName) == 0 &&
        compareTo("xxxx",str(type)) == 0){
            dumpHeap("/home/admin/bdump.bin", true);
            println("=============");
            print(beanName);
            print("|");
            println(str(type));
        }
    }
}
