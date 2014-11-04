import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class MethodTraceMuilt2 {
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
            , method = "isTypeMatch"
            , location = @Location(Kind.RETURN))
    public static void funcTypeMatch(@Return boolean typeMatch
            , @ProbeMethodName String pmn
            , String beanName
            , Class targetType
    ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        print(name(targetType));
        print("=");
        println(typeMatch);
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "isTypeMatch"
            , location = @Location(value = Kind.LINE,line = -1))
    public static void funcTypeMatchLine(
            @ProbeMethodName String pmn
            , int line
    ) {
        print("=");
        print(pmn);
        print("=");
        println(line);
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "transformedBeanName"
            , location = @Location(Kind.RETURN))
    public static void func3(@Return String isFB, @ProbeMethodName String pmn, String beanName
    ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        println(isFB);
    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.DefaultSingletonBeanRegistry"
            , method = "getSingleton"
            , location = @Location(Kind.RETURN))
    public static void func(@Return Object instance, @ProbeMethodName String pmn
            , String beanName, boolean b
    ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        if (instance != null)
            println(name(classOf(instance)));
        else
            println("inull");

    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "resolveBeanClass"
            , location = @Location(Kind.RETURN))
    public static void func(@Return Class cls, @ProbeMethodName String pmn, org.springframework.beans.factory.support.RootBeanDefinition mbd
            , String beanName
            , Class[] clses
    ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        println(name(cls));

    }

    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "isSingleton"
            , location = @Location(Kind.RETURN))
    public static void funcIsSigleton(@Return Class cls, @ProbeMethodName String pmn, org.springframework.beans.factory.support.RootBeanDefinition mbd
            , String beanName
            , Class[] clses
    ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        if (cls != null)
            println(name(cls));
        else
            println("cnull");
    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractBeanFactory"
            , method = "getTypeForFactoryBean"
            , location = @Location(Kind.RETURN))
    public static void funcIsSigleton(@Return Class cls, @ProbeMethodName String pmn , String beanName, org.springframework.beans.factory.support.RootBeanDefinition mbd
    ) {
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        if (cls != null)
            println(name(cls));
        else
            println("cnull");
    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory"
            , method = "getSingletonFactoryBeanForTypeCheck"
            , location = @Location(Kind.RETURN))
    public static void funcIsSigleton(@Return Class cls,@ProbeClassName String pcn, @ProbeMethodName String pmn , String beanName, org.springframework.beans.factory.support.RootBeanDefinition mbd
    ) {
        print("=");
        print(pcn);
        print("=");
        print(pmn);
        print("=");
        print(beanName);
        print("=");
        if (cls != null)
            println(name(cls));
        else
            println("cnull");
    }
    @OnMethod(clazz = "org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory"
            , method = "getSingletonFactoryBeanForTypeCheck"
            , location = @Location(value = Kind.LINE,line = -1))
    public static void funcIsSigleton2(@ProbeClassName String pcn, @ProbeMethodName String pmn , int line
    ) {
        print("=");
        print(pcn);
        print("=");
        print(pmn);
        print("=");
            println(line);
    }

}