package dilu.kxq.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: dilu.kxq
 * Date: 14-8-10
 * To change this template use File | Settings | File Templates.
 */
@BTrace
public class ProbeLine {

    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultListableBeanFactory", method = "getBeanNamesForType")
    public static void start(@Self Object obj, Class type, boolean includeNonSingletons, boolean allowEagerInit) {
        if (compareTo("xxxx", str(type)) == 0) {
            println("getBeanNamesForType~~~~~~~~~~~~~~~~");
            printFields(obj);
            jstack();
        }
    }

    @OnMethod(clazz = "xxxx"
            , method = "getBeanDefinitionNames", location = @Location(value = Kind.RETURN))
    public static void print232(@Self Object obj, String[] strings) {
        println("================");
        println("getBeanDefinitionNames");
        printFields(obj);
        printArray(strings);
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultSingletonBeanRegistry"
            , method = "getSingletonNames", location = @Location(Kind.RETURN))
    public static void printReturn4(@Self Object self, @Return java.lang.String[] strings) {
        println("================");
        printArray(strings);
        printFields(self);
        jstack();
        println("getSingletonNames");
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "getMergedLocalBeanDefinition", location = @Location(Kind.RETURN))
    public static void getMergedLocalBeanDefinition(@Return org.springframework.beans.factory.support.RootBeanDefinition strings
            , String beanName) {
        println("================");
        println("getMergedLocalBeanDefinition");
        println(beanName);
        printFields(strings);
        jstack();
    }
}
