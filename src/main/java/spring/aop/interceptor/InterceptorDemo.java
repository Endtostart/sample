package spring.aop.interceptor;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InterceptorDemo {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyMethodInterceptor.class,TestInterfaceImpl.class,ConfigBean.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("spring.aop.interceptor");
        TestInterface proxyBean = (TestInterface) context.getBean("proxyBean");
        System.out.println("begain");
        proxyBean.say();
        System.out.println("end");
    }

}
