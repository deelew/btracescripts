package dilu.kxq.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class MethodStackTrace {
<<<<<<< HEAD

    //    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory", method = "addBeanPostProcessor")
//    public static void func(@ProbeMethodName String pmn, org.springframework.beans.factory.config.BeanPostProcessor processor) {
//        print("=");
//        print(pmn);
//        print("=");
//        print(name(classOf(processor)));
//        print("=");
//        printFields(processor);
//        jstack();
//    }
//
//    @OnMethod(clazz = "org.springframework.context.support.AbstractApplicationContext", method = "registerBeanPostProcessors")
//    public static void func2(@ProbeMethodName String pmn , org.springframework.beans.factory.config.ConfigurableListableBeanFactory singletonFactory) {
//        print("=");
//        print(pmn);
//        print("=");
//        println(name(classOf(singletonFactory)));
//        printFields(singletonFactory);
//        jstack();
//    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory"
            , method = "getTypeForFactoryBean")
    public static void func2(@Self Object self  , @ProbeMethodName String pmn, String beanName
            , org.springframework.beans.factory.support.RootBeanDefinition bd
            ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        println(name(classOf(self)));
        printFields(bd);
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.FactoryBeanRegistrySupport"
            ,method = "getTypeForFactoryBean"
            , location = @Location(Kind.RETURN))
    public static void func3(@Return Class cls ,  @ProbeMethodName String pmn, org.springframework.beans.factory.FactoryBean fb) {
        print("=");
        print(pmn);
        print("=");
        println(name(cls));
        printFields(fb);
    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            ,method = "isTypeMatch"
            , location = @Location(Kind.RETURN))
    public static void func4(@Return boolean r ,  @ProbeMethodName String pmn, String  beanName, Class target) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        print(name(target));
        print("=");
        println(r);
    }
=======
        @OnMethod(clazz = "com.taobao.trade.timeout.notify.processor.backward.RefundCloseProcessor", method = "process")
        public static void func() {
            
                println("=======stack======");
                jstack();
                println("########end#########");
        
        }
>>>>>>> e4a6a3b03f0bd55b0f6734231b13300f057f0c8f
}
