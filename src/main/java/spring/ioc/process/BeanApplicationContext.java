package spring.ioc.process;

import common.utils.StringUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanApplicationContext implements ApplicationContextAware , InitializingBean {

    public void init(){
        //todo
    }
    // 注入容器上下文
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanApplicationContext.applicationContext = applicationContext;
    }

    /**
     * bean 实例化后回调方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    /**
     * 从容器中获取bean
     * @param name
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String name) throws BeansException {
        name = StringUtil.toLowerCaseFirstOne(name);
        if (applicationContext == null){
            return null;
        }
        return (T)applicationContext.getBean(name);
    }
}
