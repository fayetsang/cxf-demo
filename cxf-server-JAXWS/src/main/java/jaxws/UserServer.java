package jaxws;

import jaxws.service.UserServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import jaxws.service.UserService;

public class UserServer {
    public static void main(String[] args) {
        // 创建 jax-ws的工厂
        JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
        // 设置对外访问地址
        serverFactoryBean.setAddress("http://localhost:2333/userService");
        // 设置提供对外访问的类
        serverFactoryBean.setServiceClass(UserServiceImpl.class);
        // 开启服务
        serverFactoryBean.create();
        // 打印
        System.out.println("server on ...");
    }
}
