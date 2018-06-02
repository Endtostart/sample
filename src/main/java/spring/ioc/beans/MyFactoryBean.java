package spring.ioc.beans;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean {
    String name;
    @Override
    public Object getObject() throws Exception {
        return new MyFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public void say(){
        System.out.println(name);
    }
}
