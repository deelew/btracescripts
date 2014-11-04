import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class MethodTraceMuilt {
    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultListableBeanFactory"
            , method = "getBeanNamesForType"
    )
    public static void func2(@ProbeMethodName String pmn
            , Class type, boolean includeNonSingletons, boolean allowEagerInit
    ) {
        print("=");
        print(pmn);
        print("=");
        println(name(type));
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "isFactoryBean"
            , location = @Location(Kind.RETURN))
    public static void func3(@Return boolean isFB, @ProbeMethodName String pmn, String beanName, org.springframework.beans.factory.support.RootBeanDefinition mbd
    ) {
        print("=");
        print(beanName);
        print("=");
        print(pmn);
        print("=");
        println(isFB);
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultSingletonBeanRegistry"
            , method = "containsSingleton"
            , location = @Location(Kind.RETURN))
    public static void func(@Return boolean contains, @ProbeMethodName String pmn
            , String beanName
    ) {
        print("=");
        print(beanName);
        print("=");
        print(pmn);
        print("=");
        println(contains);

    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "resolveBeanClass"
            , location = @Location(Kind.RETURN))
    public static void func(@Return Class cls, @ProbeMethodName String pmn, org.springframework.beans.factory.support.RootBeanDefinition mbd
            , String beanName
            , Class[] clses
    ) {
        print("=");
        print(beanName);
        print("=");
        print(pmn);
        print("=");
        println(name(cls));

    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultSingletonBeanRegistry"
            , method = "isSingleton"
            , location = @Location(Kind.RETURN))
    public static void funcIsSigleton(@Return boolean isFB, @ProbeMethodName String pmn, String beanName
    ) {
        print("=");
        print(beanName);
        print("=");
        print(pmn);
        print("=");
        println(isFB);
    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "isTypeMatch"
            , location = @Location(Kind.RETURN))
    public static void funcTypeMatch(@Return boolean typeMatch
            , String beanName
            , Class targetType
    ) {
        print("=");
        print(beanName);
        print("=");
        print(name(targetType));
        print("=");
        println(typeMatch);
    }
}