package jaxrs;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import jaxrs.service.UserServiceImpl;


public class UserServer {
    public static void main(String[] args) throws InterruptedException {
        // 创建 jax-rs的工厂
        JAXRSServerFactoryBean serverFactoryBean = new JAXRSServerFactoryBean();
        serverFactoryBean.getInInterceptors().add(new LoggingInInterceptor());
        serverFactoryBean.getOutInterceptors().add(new LoggingOutInterceptor());

        serverFactoryBean.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);

        // 设置对外访问地址
        serverFactoryBean.setAddress("http://localhost:6666/rs");

        // 设置提供对外访问的类
        serverFactoryBean.setResourceClasses(UserServiceImpl.class);

        // 开启服务
        Server server = serverFactoryBean.create();

        // 打印
        System.out.println("server on ...");
    }
}
